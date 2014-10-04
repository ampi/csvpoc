package com.csv.entity;

/**
 * @author amin
 * 
 */
public class ProcessRecordsOldFormat {

	private String processStep;
	private String measure;
	private String value;

	public ProcessRecordsOldFormat() {
	}

	public String getProcessStep() {
		return processStep;
	}

	public void setProcessStep(String processStep) {
		this.processStep = processStep;
	}

	public String getMeasure() {
		return measure;
	}

	public void setMeasure(String measure) {
		this.measure = measure;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}	

	@Override
	public String toString() {
		return "ProcessRecordsOldFormat [processStep=" + processStep + ", measure=" + measure
				+ ", value=" + value + "]" + "\n";
	}
}