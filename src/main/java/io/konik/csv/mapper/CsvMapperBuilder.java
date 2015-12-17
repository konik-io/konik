package io.konik.csv.mapper;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.*;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.dozer.CsvDozerBeanData;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CsvMapperBuilder {

	private final CopyOnWriteArrayList<Column> columns = new CopyOnWriteArrayList<Column>();

	public CsvMapperBuilder add(Column.Builder builder) {
		columns.add(builder.build());
		return this;
	}

	public CellProcessor[] getCellProcessors() {
		return Lists.transform(columns, new Function<Column, CellProcessor>() {
			public CellProcessor apply(Column column) {
				return column.processor;
			}
		}).toArray(new CellProcessor[columns.size()]);
	}

	public String[] getColumnNames() {
		return Lists.transform(columns, new Function<Column, String>() {
			public String apply(Column column) {
				return column.name;
			}
		}).toArray(new String[columns.size()]);
	}

	public DozerBeanMapper buildBeanMapper(final Class<?> destinationObjectClass) {
		DozerBeanMapper beanMapper = new DozerBeanMapper();
		beanMapper.addMapping(new BeanMappingBuilder() {
			@Override
			protected void configure() {
				TypeMappingBuilder readerBuilder = mapping(CsvDozerBeanData.class, destinationObjectClass,
						TypeMappingOptions.oneWay(),
						TypeMappingOptions.wildcard(false),
						TypeMappingOptions.mapNull(false));

				TypeMappingBuilder writerBuilder = mapping(destinationObjectClass,
						type(CsvDozerBeanData.class).mapNull(true),
						TypeMappingOptions.oneWay(),
						TypeMappingOptions.wildcard(false));

				for (int i = 0; i < columns.size(); i++) {
					Column column = columns.get(i);

					if (column == null) {
						throw new NullPointerException(String.format("fieldMapping at index %d should not be null", i));
					}

					String srcField = "columns["+i+"]";

					if (column.fieldDefinition != null) {
						readerBuilder.fields(srcField, column.fieldDefinition, column.mappingOptions);
					} else {
						readerBuilder.fields(srcField, column.name, column.mappingOptions);
					}

					writerBuilder.fields(column.name, srcField, FieldsMappingOptions.copyByReference());
				}
			}
		});

		return beanMapper;
	}

	public static Column.Builder column(String header) {
		return Column.builder().name(header);
	}

	static class Column {
		final String name;
		final Class<?> type;
		final CellProcessor processor;
		final FieldsMappingOption[] mappingOptions;
		final FieldDefinition fieldDefinition;

		public Column(Builder builder) {
			this.name = builder.name;
			this.type = builder.type;
			this.processor = builder.processor;
			this.mappingOptions = builder.mappingOptions.toArray(new FieldsMappingOption[builder.mappingOptions.size()]);
			this.fieldDefinition = builder.fieldDefinition;
		}

		public static Builder builder() {
			return new Builder();
		}

		public static class Builder {
			private String name;
			private Class<?> type = String.class;
			private CellProcessor processor = new Optional();
			private List<FieldsMappingOption> mappingOptions = new LinkedList<FieldsMappingOption>();
			private FieldDefinition fieldDefinition;

			public Builder name(String name) {
				this.name = name;
				this.fieldDefinition = new FieldDefinition(name).setMethod(String.format("set%s", capitalize(extractChildsField(name))));
				return this;
			}
			public Builder type(Class<?> type) {
				this.type = type;
				return this;
			}
			public Builder processor(CellProcessor processor) {
				this.processor = processor;
				return this;
			}
			public Builder mappingOptions(FieldsMappingOption... mappingOptions) {
				this.mappingOptions.addAll(Arrays.asList(mappingOptions));
				return this;
			}
			public Builder fieldDefinition(FieldDefinition fieldDefinition) {
				this.fieldDefinition = fieldDefinition;
				return this;
			}
			public Column build() {
				if (mappingOptions.isEmpty()) {
					mappingOptions.add(FieldsMappingOptions.hintB(type));
				}
				return new Column(this);
			}

			private static String capitalize(String str) {
				if (str != null && str.length() > 0) {
					return str.substring(0,1).toUpperCase() + str.substring(1);
				}
				return str;
			}

			private static String extractChildsField(String path) {
				if (path.lastIndexOf(".") >= 0) {
					return path.substring(path.lastIndexOf(".") + 1);
				}
				return path;
			}
		}
	}
}
