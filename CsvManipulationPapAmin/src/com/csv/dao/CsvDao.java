/**
 * 
 */
package com.csv.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.csv.entity.ProcessRecordsNewFormat;

/**
 * @author amin
 *
 */
public class CsvDao {
	
	public CsvDao(){
		
	}
	
	public List<ProcessRecordsNewFormat> getNewProcessSteps(){
		List<ProcessRecordsNewFormat> processSteps = new ArrayList<ProcessRecordsNewFormat>();
		
		ProcessRecordsNewFormat step1 = new ProcessRecordsNewFormat(1.2, 1.0,
				2.2, 2.0, 3.2, 3.0, 4.2, 4.0, 5.2, 5.0);
		ProcessRecordsNewFormat step2 = new ProcessRecordsNewFormat(10.2, 10.0,
				20.2, 20.0, 30.2, 30.0, 40.2, 40.0, 50.2, 50.0);
		ProcessRecordsNewFormat step3 = new ProcessRecordsNewFormat(11.2, 11.0,
				21.2, 21.0, 31.2, 31.0, 41.2, 41.0, 51.2, 51.0);
		ProcessRecordsNewFormat step4 = new ProcessRecordsNewFormat(15.2, 15.0,
				25.2, 25.0, 35.2, 35.0, 45.2, 45.0, 55.2, 55.0);
		
		processSteps.add(step1);
		processSteps.add(step2);
		processSteps.add(step3);
		processSteps.add(step4);
		
		return processSteps;		
	}
	
	
	/**
	 * average Stops
	 * @return average Stops
	 */
	public List<Double> getAvStops(){
		List<ProcessRecordsNewFormat> steps = new ArrayList<ProcessRecordsNewFormat>();
		steps = getNewProcessSteps();
		List<Double> avStops = new ArrayList<Double>();
		
		Iterator<ProcessRecordsNewFormat> iterator = steps.iterator();
		while(iterator.hasNext()){
			avStops.add(iterator.next().getAverageStops());
		}
		
		return avStops;
	}
	
	/**
	 * Stops
	 * @return errors
	 */
	
	public List<Double> getErrorStops(){
		List<ProcessRecordsNewFormat> steps = new ArrayList<ProcessRecordsNewFormat>();
		steps = getNewProcessSteps();
		List<Double> errorStops = new ArrayList<Double>();
		
		Iterator<ProcessRecordsNewFormat> iterator = steps.iterator();
		while(iterator.hasNext()){
			errorStops.add(iterator.next().getErrorStops());
		}
		
		return errorStops;
	}
	
	
	/**
	 * average Hazards
	 * @return average Hazards
	 */
	public List<Double> getAvHazards(){
		List<ProcessRecordsNewFormat> steps = new ArrayList<ProcessRecordsNewFormat>();
		steps = getNewProcessSteps();
		List<Double> avHazards = new ArrayList<Double>();
		
		Iterator<ProcessRecordsNewFormat> iterator = steps.iterator();
		while(iterator.hasNext()){
			avHazards.add(iterator.next().getAverageHazards());
		}
		
		return avHazards;
	}
	
	
	/**
	 * Hazards
	 * @return errors
	 */
	
	public List<Double> getErrorHazards(){
		List<ProcessRecordsNewFormat> steps = new ArrayList<ProcessRecordsNewFormat>();
		steps = getNewProcessSteps();
		List<Double> errorHazards = new ArrayList<Double>();
		
		Iterator<ProcessRecordsNewFormat> iterator = steps.iterator();
		while(iterator.hasNext()){
			errorHazards.add(iterator.next().getErroHazards());
		}
		
		return errorHazards;
	}
	
	
	/**
	 * average Round trips
	 * @return average Round trips
	 */
	public List<Double> getAvRoundtrips(){
		List<ProcessRecordsNewFormat> steps = new ArrayList<ProcessRecordsNewFormat>();
		steps = getNewProcessSteps();
		List<Double> avRoundtrips = new ArrayList<Double>();
		
		Iterator<ProcessRecordsNewFormat> iterator = steps.iterator();
		while(iterator.hasNext()){
			avRoundtrips.add(iterator.next().getAverageRoundTrips());
		}
		
		return avRoundtrips;
	}
	
	/**
	 * Round trips
	 * @return errors
	 */
	
	public List<Double> getErrorRoundtrips(){
		List<ProcessRecordsNewFormat> steps = new ArrayList<ProcessRecordsNewFormat>();
		steps = getNewProcessSteps();
		List<Double> errorRoundtrips = new ArrayList<Double>();
		
		Iterator<ProcessRecordsNewFormat> iterator = steps.iterator();
		while(iterator.hasNext()){
			errorRoundtrips.add(iterator.next().getErrorRoundTrips());
		}
		
		return errorRoundtrips;
	}
	
	
	/**
	 * average Fuel
	 * @return average Fuel
	 */
	public List<Double> getAvFuel(){
		List<ProcessRecordsNewFormat> steps = new ArrayList<ProcessRecordsNewFormat>();
		steps = getNewProcessSteps();
		List<Double> avFuel = new ArrayList<Double>();
		
		Iterator<ProcessRecordsNewFormat> iterator = steps.iterator();
		while(iterator.hasNext()){
			avFuel.add(iterator.next().getAverageFuel());
		}
		
		return avFuel;
	}
	
	/**
	 * ErrorFuel
	 * @return errors
	 */
	
	public List<Double> getErrorFuel(){
		List<ProcessRecordsNewFormat> steps = new ArrayList<ProcessRecordsNewFormat>();
		steps = getNewProcessSteps();
		List<Double> errorFuel = new ArrayList<Double>();
		
		Iterator<ProcessRecordsNewFormat> iterator = steps.iterator();
		while(iterator.hasNext()){
			errorFuel.add(iterator.next().getErrorFuel());
		}
		
		return errorFuel;
	}
	
	
	/**
	 * average duration
	 * @return average duration
	 */
	public List<Double> getAvDurations(){
		List<ProcessRecordsNewFormat> steps = new ArrayList<ProcessRecordsNewFormat>();
		steps = getNewProcessSteps();
		List<Double> avDurations = new ArrayList<Double>();
		
		Iterator<ProcessRecordsNewFormat> iterator = steps.iterator();
		while(iterator.hasNext()){
			avDurations.add(iterator.next().getAverageDuration());
		}
		
		return avDurations;
	}
	
	/**
	 * ErrorDurations
	 * @return errors
	 */
	
	public List<Double> getErrorDurations(){
		List<ProcessRecordsNewFormat> steps = new ArrayList<ProcessRecordsNewFormat>();
		steps = getNewProcessSteps();
		List<Double> errorDurations = new ArrayList<Double>();
		
		Iterator<ProcessRecordsNewFormat> iterator = steps.iterator();
		while(iterator.hasNext()){
			errorDurations.add(iterator.next().getErrorDuration());
		}
		
		return errorDurations;
	}

}
