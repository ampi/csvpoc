/**
 * 
 */
package com.csv.format;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author amin
 *
 */
public interface CSVFormat {
	
	public Map<Double, Map<List<String>, Map<List<Double>,List<Double>>>> makeHeaders() throws FileNotFoundException, IOException;
	
	public List<String> getSortedHeaders() throws FileNotFoundException, IOException, Exception;
	
	public  List<Double> getRows() throws FileNotFoundException, IOException;
	
	public List<Double> getOrderedErros() throws FileNotFoundException, IOException;

}
