package io.konik.csv.mapper;

import io.konik.csv.mapper.CsvMapperBuilder.Column;

public interface ColumnsConfigurer {
   Column getColumnDefinitionForHeader(String header);
}
