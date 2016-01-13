package io.konik.csv.pdf;

import io.konik.PdfHandler;
import io.konik.csv.mapper.CsvInvoicesReader;
import io.konik.csv.model.Row;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

import static io.konik.csv.mapper.CsvInvoicesReader.ConvertedRow;
import static io.konik.csv.mapper.CsvInvoicesReader.Result;

public class CsvToZUGFeRDConverter {

	private static final Logger log = LoggerFactory.getLogger(CsvToZUGFeRDConverter.class);

	private final CsvInvoicesReader csvInvoicesReader;
	private final PdfHandler pdfHandler;

	public CsvToZUGFeRDConverter() {
		this.csvInvoicesReader = new CsvInvoicesReader();
		this.pdfHandler = new PdfHandler();
	}

	public CsvToZUGFeRDConverter(CsvInvoicesReader csvInvoicesReader, PdfHandler pdfHandler) {
		this.csvInvoicesReader = csvInvoicesReader;
		this.pdfHandler = pdfHandler;
	}

	public void convert(File csvFile) {
		Result result = csvInvoicesReader.read(csvFile);

		if (result != null) {
			for (final ConvertedRow convertedRow : result.getConvertedRows()) {
				InputStream input = null;
				OutputStream output = null;

				try {
					final Row row = convertedRow.getRow();

					if (row != null && row.getFile().getInput() != null) {
						input = new FileInputStream(row.getFile().getInput());

						String outputName = row.getFile().getOutput();
						if (!(outputName != null && !outputName.isEmpty())) {
							outputName = row.getFile().getInput().replaceFirst("/\\.pdf$/", "_zugferd.pdf");
						}

						output = new FileOutputStream(outputName);

						pdfHandler.appendInvoice(convertedRow.getInvoice(), input, output);
					}
				} catch (IOException e) {
					log.warn("IOException caught: {}", e.getMessage());
				} finally {
					try {
						if (input != null) {
							input.close();
						}

						if (output != null) {
							output.close();
						}
					} catch (IOException e) {
						log.warn("IOException caught while closing input or output: {}", e.getMessage());
					}
				}
			}
		}
	}
}
