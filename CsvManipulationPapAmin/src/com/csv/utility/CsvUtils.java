/**
 * 
 */
package com.csv.utility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

/**
 * @author amin
 *
 */
public class CsvUtils {
	
	public CsvUtils(){
		
	}	
	
	public static CSVParser getParser() throws FileNotFoundException, IOException{
		
		// create the CVSFormat
		CSVFormat format = getFormat();

		// initialize the CSVParser object to parse the csv file.
		CSVParser parser = new CSVParser(new FileReader(CsvUtilProperties.FILE),
				format);
		
		return parser;
	}
	
	public static CSVFormat getFormat(){
		
		CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(CsvUtilProperties.DELIMITER);
		
		return format;
	}
	
	public static CSVPrinter printToPrompt() throws IOException{
		CSVPrinter printToPrompt = new CSVPrinter(System.out,
				getFormat().withDelimiter(';'));

		
		return printToPrompt;
	}
	
	public static CSVPrinter writeToCSVFile() throws IOException{
		CSVPrinter writeToCSVFile = new CSVPrinter(new FileWriter(
				"csv/output.csv"), getFormat().withDelimiter(';'));
		
		return writeToCSVFile;	
	}
	
	/**
	 * @return number of rows, exclude header
	 * @throws FileNotFoundException
	 * @throws IOException
	 */	
	
	public static int getRowSize() throws FileNotFoundException, IOException{
		
		int size = getParser().getRecords().size();
		
		getParser().close();
		
		return size;
	}
	

}
