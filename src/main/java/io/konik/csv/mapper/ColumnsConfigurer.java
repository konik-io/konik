package io.konik.csv.mapper;

import static io.konik.csv.mapper.CsvMapperBuilder.Column;

public interface ColumnsConfigurer {
   Column getColumnDefinitionForHeader(String header);
}
