/**
 * 
 */
package com.csv.format;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.csv.dao.CsvDao;

/**
 * @author amin
 * 
 */
public class CSVFormatImpl implements CSVFormat {

	@Override
	public Map<Double, Map<List<String>, Map<List<Double>,List<Double>>>> makeHeaders()
			throws FileNotFoundException, IOException {

		CsvDao dao = new CsvDao();

		// Duration
		// Map<List<Double>, Map<List<String>,List<Double>>> durationMap = new
		// HashMap<List<Double>, Map<List<String>,List<Double>>> ();
		
		/**
		 * DURATION 
		 */
		Map<List<String>, Map<List<Double>, List<Double>>> durationMap = new HashMap<List<String>, Map<List<Double>, List<Double>>>();
		Map<List<Double>, List<Double>> duMeasuresAndErrors = new HashMap<List<Double>, List<Double>>(); 
		
		//duration values
		List<Double> avDurationCol = new ArrayList<Double>();
		avDurationCol.addAll(dao.getAvDurations());
		//Error durations
		List<Double> errorDurationCol = new ArrayList<Double>();
		errorDurationCol.addAll(dao.getErrorDurations());
		
		//Put Duration values and error values
		duMeasuresAndErrors.put(avDurationCol, avDurationCol);
		
		
		List<String> durationHeaders = new ArrayList<String>();
		durationHeaders.add("Average Duration");
		durationHeaders.add("Error Duration");
		durationMap.put(durationHeaders, duMeasuresAndErrors);

		// durationMap.put(avDurationRow, durationList);

		/**
		 * FUEL
		 */
		
		// Fuel
		Map<List<String>, Map<List<Double>,List<Double>>> fuelMap = new HashMap<List<String>, Map<List<Double>,List<Double>>>();
		Map<List<Double>, List<Double>> fuelMeasuresAndErrors = new HashMap<List<Double>, List<Double>>();
				
		List<Double> avFuelCol = new ArrayList<Double>();
		avFuelCol.addAll(dao.getAvFuel());
		List<Double> errorFuelCol = new ArrayList<Double>();
		errorFuelCol.addAll(dao.getErrorFuel());
		fuelMeasuresAndErrors.put(avFuelCol, errorFuelCol);		
		
		List<String> fuelheaders = new ArrayList<String>();
		fuelheaders.add("Average Fuel");
		fuelheaders.add("Error Fuel");
		fuelMap.put(fuelheaders, fuelMeasuresAndErrors);
		
		/**
		 * Round trips
		 */

		// Round trips
		Map<List<String>, Map<List<Double>, List<Double>>> roundtripsMap = new HashMap<List<String>, Map<List<Double>, List<Double>>>();
		Map<List<Double>, List<Double>> rtMeasuresAndErrors = new HashMap<List<Double>, List<Double>>();
			
		List<Double> avRoundtripsCol = new ArrayList<Double>();
		avRoundtripsCol.addAll(dao.getAvRoundtrips());
		List<Double> errorRoundtripsCol = new ArrayList<Double>();
		errorRoundtripsCol.addAll(dao.getErrorRoundtrips());
		rtMeasuresAndErrors.put(avRoundtripsCol, errorRoundtripsCol);
		
		List<String> roundtripHeaders = new ArrayList<String>();
		roundtripHeaders.add("Average Round trips");
		roundtripHeaders.add("Error Round trips");
		roundtripsMap.put(roundtripHeaders, rtMeasuresAndErrors);
		
		/**
		 * Hazards
		 */

		// Hazards
		Map<List<String>, Map<List<Double>, List<Double>>> hazardsMap = new HashMap<List<String>, Map<List<Double>, List<Double>>>();
		Map<List<Double>, List<Double>> hazMeasuresAndErrors = new HashMap<List<Double>, List<Double>>();
		
		List<Double> avHazardsCol = new ArrayList<Double>();
		avHazardsCol.addAll(dao.getAvHazards());
		List<Double> errorHazardsCol = new ArrayList<Double>();
		errorHazardsCol.addAll(dao.getErrorHazards());
		hazMeasuresAndErrors.put(avHazardsCol, errorHazardsCol);
		
		List<String> hazardHeaders = new ArrayList<String>();
		hazardHeaders.add("Average Hazards");
		hazardHeaders.add("Error Hazards");
		hazardsMap.put(hazardHeaders, hazMeasuresAndErrors);
		
		/**
		 * Stops
		 */
		// Stops
		Map<List<String>, Map<List<Double>,List<Double>>> stopsMap = new HashMap<List<String>, Map<List<Double>,List<Double>>>();
		Map<List<Double>, List<Double>> stopMeasuresAndErrors = new HashMap<List<Double>, List<Double>>();
		
		List<Double> avStopsCol = new ArrayList<Double>();
		avStopsCol.addAll(dao.getAvStops());
		List<Double> errorStopsCol = new ArrayList<Double>();
		errorStopsCol.addAll(dao.getErrorStops());
		stopMeasuresAndErrors.put(avStopsCol, errorStopsCol);
		
		List<String> stopsHeaders = new ArrayList<String>();
		stopsHeaders.add("Average Stops");
		stopsHeaders.add("Error Stops");
		stopsMap.put(stopsHeaders, stopMeasuresAndErrors);
		

		Map<Double, Map<List<String>, Map<List<Double>, List<Double>>>> sortedHeaders = new TreeMap<Double, Map<List<String>, Map<List<Double>, List<Double>>>>(
				Collections.reverseOrder());

		// Sum of duration errors
		List<Double> durationErrors = new ArrayList<Double>(); 		
		durationErrors.addAll(dao.getErrorDurations());		
		double duErr = 0;		
		for(int i = 0; i < durationErrors.size(); i++ ){
			duErr += durationErrors.get(i);
		}		
		sortedHeaders.put(duErr, durationMap);
		
		// Sum of fuel errors
		List<Double> fuelErrors = new ArrayList<Double>(); 		
		fuelErrors.addAll(dao.getErrorFuel());		
		double fuErr = 0;		
		for(int i = 0; i < fuelErrors.size(); i++ ){
			fuErr += fuelErrors.get(i);
		}		
		sortedHeaders.put(fuErr, fuelMap);
		
		// Sum of round trips errors
		List<Double> roundtripsErrors = new ArrayList<Double>();
		roundtripsErrors.addAll(dao.getErrorRoundtrips());		
		double roundErr = 0;		
		for(int i = 0; i < roundtripsErrors.size(); i++ ){
			roundErr += roundtripsErrors.get(i);
		}
		sortedHeaders.put(roundErr, roundtripsMap);

		// Sum of hazards errors
		List<Double> hazardsErrors = new ArrayList<Double>(); 		
		hazardsErrors.addAll(dao.getErrorHazards());		
		double hazErr = 0;		
		for(int i = 0; i < hazardsErrors.size(); i++ ){
			hazErr += hazardsErrors.get(i);
		}		
		sortedHeaders.put(hazErr, fuelMap);

		// Sum of stops errors
		List<Double> stopsErrors = new ArrayList<Double>(); 		
		stopsErrors.addAll(dao.getErrorStops());		
		double stopErr = 0;		
		for(int i = 0; i < stopsErrors.size(); i++ ){
			stopErr += stopsErrors.get(i);
		}		
		sortedHeaders.put(stopErr, stopsMap);

		return sortedHeaders;
	}

	@Override
	public List<String> getSortedHeaders() throws FileNotFoundException,
			IOException, Exception {
		Map<Double, Map<List<String>, Map<List<Double>,List<Double>>>> csvData = new TreeMap<Double, Map<List<String>, Map<List<Double>,List<Double>>>>();
		Map<List<String>,Map<List<Double>, List<Double>>> headerValues = new HashMap <List<String>,Map<List<Double>,List<Double>>>();
		
		List<String> sumKey = new ArrayList<String>();
		List<String> sortedHeaders = new ArrayList<String>();

		csvData = makeHeaders();

		for (Entry<Double, Map<List<String>, Map<List<Double>, List<Double>>>> valueMap : csvData
				.entrySet()) {
			headerValues = valueMap.getValue();

			for (Map.Entry<List<String>, Map<List<Double>, List<Double>>> measureMap : headerValues
					.entrySet()) {
				sumKey = measureMap.getKey();

				for (int i = 0; i < sumKey.size(); i++) {
					sortedHeaders.add(sumKey.get(i));
				}
			}

		}

		return sortedHeaders;
	}

	@Override
	public List<Double> getRows() throws FileNotFoundException, IOException {
		//Map<Double, Map<List<String>, List<Double>>> headers = new TreeMap<Double, Map<List<String>, List<Double>>>();
		Map<Double, Map<List<String>, Map<List<Double>,List<Double>>>> csvData = new TreeMap<Double, Map<List<String>, Map<List<Double>,List<Double>>>>();
		Map<List<String>, Map<List<Double>,List<Double>>> headerValues = new HashMap<List<String>, Map<List<Double>,List<Double>>>();
		Map<List<Double>,List<Double>> measures = new HashMap<List<Double>,List<Double>>();
		
		List<Double> records = new ArrayList<Double>();
		List<Double> rows = new ArrayList<Double>();

		csvData = makeHeaders();

		for (Entry<Double, Map<List<String>, Map<List<Double>,List<Double>>>> valueMap : csvData
				.entrySet()) {
			headerValues = valueMap.getValue();

			for (Entry<List<String>, Map<List<Double>, List<Double>>> measureMap : headerValues
					.entrySet()) {
				measures = measureMap.getValue();
				
				for(Map.Entry<List<Double>, List<Double>> measureValues : measures.entrySet() ){
					
					records = measureValues.getKey();
							
				for (int i = 0; i < records.size(); i++) {
					rows.add(records.get(i));
				}
				
				}

			}

		}

		return rows;
	}
	
	public List<Double> getErrorRows() throws FileNotFoundException, IOException {
		//Map<Double, Map<List<String>, List<Double>>> headers = new TreeMap<Double, Map<List<String>, List<Double>>>();
		Map<Double, Map<List<String>, Map<List<Double>,List<Double>>>> csvData = new TreeMap<Double, Map<List<String>, Map<List<Double>,List<Double>>>>();
		Map<List<String>, Map<List<Double>,List<Double>>> headerValues = new HashMap<List<String>, Map<List<Double>,List<Double>>>();
		Map<List<Double>,List<Double>> measures = new HashMap<List<Double>,List<Double>>();
		
		List<Double> records = new ArrayList<Double>();
		List<Double> rows = new ArrayList<Double>();

		csvData = makeHeaders();

		for (Entry<Double, Map<List<String>, Map<List<Double>,List<Double>>>> valueMap : csvData
				.entrySet()) {
			headerValues = valueMap.getValue();

			for (Entry<List<String>, Map<List<Double>, List<Double>>> measureMap : headerValues
					.entrySet()) {
				measures = measureMap.getValue();
				
				for(Map.Entry<List<Double>, List<Double>> measureValues : measures.entrySet() ){
					
					records = measureValues.getValue();
							
				for (int i = 0; i < records.size(); i++) {
					rows.add(records.get(i));
				}
				
				}

			}

		}

		return rows;
	}

	@Override
	public List<Double> getOrderedErros() throws FileNotFoundException,
			IOException {
		//Map<Double, Map<List<String>, List<Double>>> errors = new TreeMap<Double, Map<List<String>, List<Double>>>();
		Map<Double, Map<List<String>, Map<List<Double>,List<Double>>>> csvData = new TreeMap<Double, Map<List<String>, Map<List<Double>,List<Double>>>>();
		csvData = makeHeaders();
		List<Double> sortedErrors = new ArrayList<Double>();
		Double errs = null;

		for (Entry<Double, Map<List<String>, Map<List<Double>,List<Double>>>> errorMap : csvData
				.entrySet()) {
			errs = errorMap.getKey();
			sortedErrors.add(errs);
		}
		return sortedErrors;
	}

}
