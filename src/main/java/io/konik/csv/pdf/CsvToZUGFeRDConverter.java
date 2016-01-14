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
	private static final String DEFAULT_SUFFIX = "_zugferd.pdf";

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

	public void convert(File csvFile, String inputPath, String outputPath) {
		Result result = csvInvoicesReader.read(csvFile);

		if (result != null) {
			for (final ConvertedRow convertedRow : result.getConvertedRows()) {
				InputStream input = null;
				OutputStream output = null;

				try {
					final Row row = convertedRow.getRow();

					if (isInputFilePresent(row)) {
						String inputFile = row.getFile().getInput();
						input = new FileInputStream(getFilePath(inputPath, inputFile));

						String outputName = row.getFile().getOutput();
						if (!(outputName != null && !outputName.isEmpty())) {
							outputName = row.getFile().getInput().replaceFirst("/\\.pdf$/", DEFAULT_SUFFIX);
						}
						output = new FileOutputStream(getFilePath(outputPath, outputName));

						pdfHandler.appendInvoice(convertedRow.getInvoice(), input, output);
					}
				} catch (IOException e) {
					log.warn("IOException caught: {}", e.getMessage());
				} finally {
					closeStreams(input, output);
				}
			}
		}
	}

	private static String getFilePath(final String inputPath, final String inputFile) {
		String result = inputFile;

		if (inputPath != null && !inputPath.isEmpty()) {
			String path = inputPath;
			String file = inputFile;

			if (!path.endsWith("/")) {
				path = String.format("%s/", path);
			}
			if (file.startsWith("/")) {
				file = file.substring(1, file.length() - 1);
			}

			result = String.format("%s%s", path, file);
		}

		return result;
	}

	public void convert(File csvFile) {
		convert(csvFile, null, null);
	}

	private boolean isInputFilePresent(Row row) {
		return row != null && row.getFile().getInput() != null;
	}

	private void closeStreams(InputStream input, OutputStream output) {
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

	public static void main(String[] args) {
		String inputPath = System.getProperty("inputPath");
		String outputPath = System.getProperty("outputPath");

		String csvFileName = args[1];

		File csvFile = new File(csvFileName);

		if (!csvFile.exists()) {
			throw new IllegalArgumentException(String.format("Csv file with name %s does not exist", csvFileName));
		}

		CsvToZUGFeRDConverter converter = new CsvToZUGFeRDConverter();
		converter.convert(csvFile, inputPath, outputPath);
	}
}
