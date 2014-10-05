/**
 * 
 */
package com.csv.utility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

import junit.framework.TestCase;

/**
 * @author amin
 *
 */
public class TestCsvUtils extends TestCase {


	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link com.csv.utility.CsvUtils#getRowSize()}.
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public void testGetRowSize() throws FileNotFoundException, IOException {
        CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(',');
        CSVParser parser = new CSVParser(new FileReader("csv/input.csv"), format);

        int rowSize = parser.getRecords().size();        
        assertEquals(rowSize, 6); 
        assertNotNull(format);
        assertNotNull(parser);
        assertNotSame(rowSize, 8);
        
        parser.close();

	}

}
