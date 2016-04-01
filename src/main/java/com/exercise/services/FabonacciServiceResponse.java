package com.exercise.services;

/**
 * This class holds information to be sent back to client.
 */
public class FabonacciServiceResponse implements ServiceResponse {
	public String note = "normal";
	public String serviceTimeStamp;
	public long [] fibNumbers;
	
	public FabonacciServiceResponse(String note, String timeStamp, long [] fibNumbers) {
		this.note = note;
		this.serviceTimeStamp = timeStamp;
		this.fibNumbers = fibNumbers;
	}
	
	public String getServiceTimeStamp() {
		return this.serviceTimeStamp;
	}
	
	public long [] getFibNumbers() {
        return this.fibNumbers;
    }

	@Override
	public String getNote() {
		return this.note;
	}
}
