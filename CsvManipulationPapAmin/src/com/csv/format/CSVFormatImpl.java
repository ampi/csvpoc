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
	public Map<Double, Map<List<String>, List<Double>>> makeHeaders()
			throws FileNotFoundException, IOException {

		CsvDao dao = new CsvDao();

		// Duration
		// Map<List<Double>, Map<List<String>,List<Double>>> durationMap = new
		// HashMap<List<Double>, Map<List<String>,List<Double>>> ();
		Map<List<String>, List<Double>> durationMap = new HashMap<List<String>, List<Double>>();
		List<String> durationHeaders = new ArrayList<String>();
		List<Double> avDurationCol = new ArrayList<Double>();

		avDurationCol.addAll(dao.getAvDurations());
		durationHeaders.add("Average Duration");
		durationHeaders.add("Error Duration");
		durationMap.put(durationHeaders, avDurationCol);

		// durationMap.put(avDurationRow, durationList);

		// Fuel
		Map<List<String>, List<Double>> fuelMap = new HashMap<List<String>, List<Double>>();
		List<String> fuelheaders = new ArrayList<String>();
		List<Double> avFuelCol = new ArrayList<Double>();
		avFuelCol.addAll(dao.getAvFuel());

		fuelheaders.add("Average Fuel");
		fuelheaders.add("Error Fuel");
		fuelMap.put(fuelheaders, avFuelCol);

		// Round trips
		Map<List<String>, List<Double>> roundtripsMap = new HashMap<List<String>, List<Double>>();
		List<String> roundtripHeaders = new ArrayList<String>();
		List<Double> avRoundtripsCol = new ArrayList<Double>();
		avRoundtripsCol.addAll(dao.getAvRoundtrips());

		roundtripHeaders.add("Average Round trips");
		roundtripHeaders.add("Error Round trips");
		roundtripsMap.put(roundtripHeaders, avRoundtripsCol);

		// Hazards
		Map<List<String>, List<Double>> hazardsMap = new HashMap<List<String>, List<Double>>();
		List<String> hazardHeaders = new ArrayList<String>();
		List<Double> avHazardsCol = new ArrayList<Double>();
		avHazardsCol.addAll(dao.getAvHazards());

		hazardHeaders.add("Average Hazards");
		hazardHeaders.add("Error Hazards");
		hazardsMap.put(hazardHeaders, avHazardsCol);

		// Stops
		Map<List<String>, List<Double>> stopsMap = new HashMap<List<String>, List<Double>>();
		List<String> stopsHeaders = new ArrayList<String>();
		List<Double> avStopsCol = new ArrayList<Double>();
		avStopsCol.addAll(dao.getAvStops());

		stopsHeaders.add("Average Stops");
		stopsHeaders.add("Error Stops");
		stopsMap.put(stopsHeaders, avStopsCol);

		Map<Double, Map<List<String>, List<Double>>> sortedHeaders = new TreeMap<Double, Map<List<String>, List<Double>>>(
				Collections.reverseOrder());

		// Duration errors
		double error1 = (int) (Math.random() * 100);
		sortedHeaders.put(error1, durationMap);

		// Fuel errors
		double error2 = (int) (Math.random() * 100);
		sortedHeaders.put(error2, fuelMap);

		double error3 = (int) (Math.random() * 100);
		sortedHeaders.put(error3, roundtripsMap);

		double error4 = (int) (Math.random() * 100);
		sortedHeaders.put(error4, hazardsMap);

		double error5 = (int) (Math.random() * 100);
		sortedHeaders.put(error5, stopsMap);

		return sortedHeaders;
	}

	@Override
	public List<String> getSortedHeaders() throws FileNotFoundException,
			IOException, Exception {
		Map<Double, Map<List<String>, List<Double>>> headers = new TreeMap<Double, Map<List<String>, List<Double>>>();
		Map<List<String>, List<Double>> headerValues = new HashMap<List<String>, List<Double>>();
		List<String> measures = new ArrayList<String>();
		List<String> sortedMeasures = new ArrayList<String>();

		headers = makeHeaders();

		for (Entry<Double, Map<List<String>, List<Double>>> valueMap : headers
				.entrySet()) {
			headerValues = valueMap.getValue();

			for (Map.Entry<List<String>, List<Double>> measureMap : headerValues
					.entrySet()) {
				measures = measureMap.getKey();

				for (int i = 0; i < measures.size(); i++) {
					sortedMeasures.add(measures.get(i));
				}
			}

		}

		return sortedMeasures;
	}

	@Override
	public List<Double> getRows() throws FileNotFoundException, IOException {
		Map<Double, Map<List<String>, List<Double>>> headers = new TreeMap<Double, Map<List<String>, List<Double>>>();
		Map<List<String>, List<Double>> headerValues = new HashMap<List<String>, List<Double>>();
		List<Double> records = new ArrayList<Double>();
		List<Double> rows = new ArrayList<Double>();

		headers = makeHeaders();

		for (Entry<Double, Map<List<String>, List<Double>>> valueMap : headers
				.entrySet()) {
			headerValues = valueMap.getValue();

			for (Map.Entry<List<String>, List<Double>> measureMap : headerValues
					.entrySet()) {
				records = measureMap.getValue();

				for (int i = 0; i < records.size(); i++) {
					rows.add(records.get(i));
				}

			}

		}

		return rows;
	}

	@Override
	public List<Double> getOrderedErros() throws FileNotFoundException,
			IOException {
		Map<Double, Map<List<String>, List<Double>>> errors = new TreeMap<Double, Map<List<String>, List<Double>>>();
		errors = makeHeaders();
		List<Double> sortedErrors = new ArrayList<Double>();
		Double errs = null;

		for (Entry<Double, Map<List<String>, List<Double>>> errorMap : errors
				.entrySet()) {
			errs = errorMap.getKey();
			sortedErrors.add(errs);
		}
		return sortedErrors;
	}

}
