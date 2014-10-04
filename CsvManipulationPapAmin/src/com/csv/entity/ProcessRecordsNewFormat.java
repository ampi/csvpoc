/**
 * 
 */
package com.csv.entity;

/**
 * @author amin
 * 
 */
public class ProcessRecordsNewFormat {

	private Double processStep;
	private Double averageDuration;
	private Double errorDuration;
	private Double averageFuel;
	private Double errorFuel;
	private Double averageRoundTrips;
	private Double errorRoundTrips;
	private Double averageHazards;
	private Double erroHazards;
	private Double averageStops;
	private Double errorStops;

	public ProcessRecordsNewFormat() {
//		setAverageDuration((int)(Math.random() * 100));
//		setAverageFuel((int)(Math.random() * 100));
//		setAverageHazards((int)(Math.random() * 100));
//		setAverageRoundTrips((int)(Math.random() * 100));
//		setAverageStops((int)(Math.random() * 100));
	}
	
	

	public ProcessRecordsNewFormat(Double averageDuration,
			Double errorDuration, Double averageFuel, Double errorFuel,
			Double averageRoundTrips, Double errorRoundTrips,
			Double averageHazards, Double erroHazards, Double averageStops,
			Double errorStops) {
		super();
		this.averageDuration = averageDuration;
		this.errorDuration = errorDuration;
		this.averageFuel = averageFuel;
		this.errorFuel = errorFuel;
		this.averageRoundTrips = averageRoundTrips;
		this.errorRoundTrips = errorRoundTrips;
		this.averageHazards = averageHazards;
		this.erroHazards = erroHazards;
		this.averageStops = averageStops;
		this.errorStops = errorStops;
	}



	/**
	 * @return the processStep
	 */
	public Double getProcessStep() {
		return processStep;
	}

	/**
	 * @param processStep the processStep to set
	 */
	public void setProcessStep(Double processStep) {
		this.processStep = processStep;
	}

	/**
	 * @return the averageDuration
	 */
	public Double getAverageDuration() {
		return averageDuration;
	}

	/**
	 * @param averageDuration the averageDuration to set
	 */
	public void setAverageDuration(Double averageDuration) {
		this.averageDuration = averageDuration;
	}

	/**
	 * @return the errorDuration
	 */
	public Double getErrorDuration() {
		return errorDuration;
	}

	/**
	 * @param errorDuration the errorDuration to set
	 */
	public void setErrorDuration(Double errorDuration) {
		this.errorDuration = errorDuration;
	}

	/**
	 * @return the averageFuel
	 */
	public Double getAverageFuel() {
		return averageFuel;
	}

	/**
	 * @param averageFuel the averageFuel to set
	 */
	public void setAverageFuel(Double averageFuel) {
		this.averageFuel = averageFuel;
	}

	/**
	 * @return the errorFuel
	 */
	public Double getErrorFuel() {
		return errorFuel;
	}

	/**
	 * @param errorFuel the errorFuel to set
	 */
	public void setErrorFuel(Double errorFuel) {
		this.errorFuel = errorFuel;
	}

	/**
	 * @return the averageRoundTrips
	 */
	public Double getAverageRoundTrips() {
		return averageRoundTrips;
	}

	/**
	 * @param averageRoundTrips the averageRoundTrips to set
	 */
	public void setAverageRoundTrips(Double averageRoundTrips) {
		this.averageRoundTrips = averageRoundTrips;
	}

	/**
	 * @return the errorRoundTrips
	 */
	public Double getErrorRoundTrips() {
		return errorRoundTrips;
	}

	/**
	 * @param errorRoundTrips the errorRoundTrips to set
	 */
	public void setErrorRoundTrips(Double errorRoundTrips) {
		this.errorRoundTrips = errorRoundTrips;
	}

	/**
	 * @return the averageHazards
	 */
	public Double getAverageHazards() {
		return averageHazards;
	}

	/**
	 * @param averageHazards the averageHazards to set
	 */
	public void setAverageHazards(Double averageHazards) {
		this.averageHazards = averageHazards;
	}

	/**
	 * @return the erroHazards
	 */
	public Double getErroHazards() {
		return erroHazards;
	}

	/**
	 * @param erroHazards the erroHazards to set
	 */
	public void setErroHazards(Double erroHazards) {
		this.erroHazards = erroHazards;
	}

	/**
	 * @return the averageStops
	 */
	public Double getAverageStops() {
		return averageStops;
	}

	/**
	 * @param averageStops the averageStops to set
	 */
	public void setAverageStops(Double averageStops) {
		this.averageStops = averageStops;
	}

	/**
	 * @return the errorStops
	 */
	public Double getErrorStops() {
		return errorStops;
	}

	/**
	 * @param errorStops the errorStops to set
	 */
	public void setErrorStops(Double errorStops) {
		this.errorStops = errorStops;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProcessRecordsNewFormat [processStep=" + processStep
				+ ", averageDuration=" + averageDuration + ", errorDuration="
				+ errorDuration + ", averageFuel=" + averageFuel
				+ ", errorFuel=" + errorFuel + ", averageRoundTrips="
				+ averageRoundTrips + ", errorRoundTrips=" + errorRoundTrips
				+ ", averageHazards=" + averageHazards + ", erroHazards="
				+ erroHazards + ", averageStops=" + averageStops
				+ ", errorStops=" + errorStops + "]";
	}
	
}
