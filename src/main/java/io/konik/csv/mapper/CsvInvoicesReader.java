package io.konik.csv.mapper;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import io.konik.csv.converter.RowToInvoiceConverter;
import io.konik.csv.model.Row;
import io.konik.zugferd.Invoice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.dozer.CsvDozerBeanReader;

import javax.annotation.Nullable;
import java.io.File;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Reader class used for reading CSV files and returning a {@link List} of {@see Invoice}s.
 *
 * This is high-level component that should be used to import invoices from CSV files.
 */
public class CsvInvoicesReader {

	private static final Logger log = LoggerFactory.getLogger(CsvInvoicesReader.class);

	private final ColumnsConfigurer columnsConfigurer;

	public CsvInvoicesReader() {
		this(new CsvMapperHeaderColumnsConfigurer());
	}

	public CsvInvoicesReader(ColumnsConfigurer columnsConfigurer) {
		this.columnsConfigurer = columnsConfigurer;
	}

	/**
	 * Loads invoices from given CSV file.
	 * @param csvFile
	 * @return
	 */
	public List<Invoice> read(File csvFile) {
		CsvMapperBuilder mapperBuilder = CsvMapperBuilder.withHeadersFromCsvFile(csvFile, columnsConfigurer);
		CellProcessor[] processors = mapperBuilder.getCellProcessors();
		CsvDozerBeanReader reader = mapperBuilder.getBeanReader(csvFile, Row.class);

		List<Row> rows = new LinkedList<Row>();
		Row currentRow = null;

		try {
			while ((currentRow = reader.read(Row.class, processors)) != null) {
				rows.add(currentRow);
			}

			reader.close();

			List<Invoice> invoices = Lists.transform(rows, new Function<Row, Invoice>() {
				@Nullable
				@Override
				public Invoice apply(Row input) {
					try {
						return RowToInvoiceConverter.convert(input);
					} catch (Exception e) {
						log.warn("Row could not be converted to invoice: {} | row = {}", e.getMessage(), input);
					}

					return null;
				}
			});

			Collection<Invoice> result = Collections2.filter(invoices, new Predicate<Invoice>() {
				@Override
				public boolean apply(@Nullable Invoice input) {
					return input != null;
				}
			});

			return new LinkedList<Invoice>(result);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
