/**
 * 
 */
package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import com.csv.format.CSVFormatImpl;
import com.csv.utility.CsvUtils;

/**
 * @author amin
 * 
 */
public class Main {
	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		CSVParser parser = CsvUtils.getParser();

		// Getting process step from csv file
		Map<String, Integer> headerOld = parser.getHeaderMap();
		List<String> processStepsOld = new ArrayList<String>();

		for (Map.Entry<String, Integer> headerOldEntry : headerOld.entrySet()) {
			processStepsOld.add(headerOldEntry.getKey());
		}

		CSVPrinter printToPrompt = CsvUtils.printToPrompt();
		CSVPrinter printerToCSVFile = CsvUtils.writeToCSVFile();

		CSVFormatImpl csvFormatImpl = new CSVFormatImpl();
		List<String> vals = new ArrayList<String>();
		vals.addAll(csvFormatImpl.getSortedHeaders());
		
		//Header output to prompt/shell
		printToPrompt.printRecord(processStepsOld.get(0), vals.get(0), vals.get(1),
				vals.get(2), vals.get(3), vals.get(4), vals.get(5),
				vals.get(6), vals.get(7), vals.get(8), vals.get(9));
		
		//Header output to csv file
		printerToCSVFile
				.printRecord(processStepsOld.get(0), vals.get(0), vals.get(1),
						vals.get(2), vals.get(3), vals.get(4), vals.get(5),
						vals.get(6), vals.get(7), vals.get(8), vals.get(9));

		// initiates process steps to write column into csv file
		List<CSVRecord> processStepsNew = parser.getRecords();
		int rowSize = CsvUtils.getRowSize();
		
		//Get sortes errors
		List<Double> sortedErrors = new ArrayList<Double>();
		sortedErrors.addAll(csvFormatImpl.getOrderedErros());
		
		//Get measure values.
		List<Double> rows = new ArrayList<Double>();
		rows.addAll(csvFormatImpl.getRows());

		// Writing to new csv file and printout to shell/prompt
		for (int i = 0; i < rowSize; i++) {
			List<String> processData = new ArrayList<String>();

			processData.add(processStepsNew.get(i).get(0).toString());
			processData.add(rows.get(0).toString());
			processData.add(sortedErrors.get(0).toString());
			processData.add(rows.get(1).toString());
			processData.add(sortedErrors.get(1).toString());
			processData.add(rows.get(2).toString());
			processData.add(sortedErrors.get(2).toString());
			processData.add(rows.get(3).toString());
			processData.add(sortedErrors.get(3).toString());
			processData.add(rows.get(4).toString());
			processData.add(sortedErrors.get(4).toString());
			printToPrompt.printRecord(processData);
			printerToCSVFile.printRecord(processData);
		}
		parser.close();
		printToPrompt.close();
		printerToCSVFile.close();

	}

}
