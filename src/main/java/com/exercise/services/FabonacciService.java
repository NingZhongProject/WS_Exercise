package com.exercise.services;

import java.util.Date;

/**
 * This is the class where provide implementation to the service.
 */
public class FabonacciService {
	private int inputNumber;
    private long [] fibNumbers;
    
    public FabonacciService(int inputNumber) {
    	this.inputNumber = inputNumber;
    }
    
	public long getInputNumber() {
    	return this.inputNumber;
    }
	
    public void setInputNumber(int inputNumber) {
		this.inputNumber = inputNumber;
	}

    public long [] getFibNumbers() {
        return fibNumbers;
    }
    
    public void obtainFibNumbers() {
    	this.fibNumbers = ServiceHelper.obtainFirstNFibNumbers(this.inputNumber);
    }
    
    public ServiceResponse obtainResponse() {
    	String timeStamp = new Date().toString();
    	FabonacciServiceResponse resp = new FabonacciServiceResponse("Numbers obtained.", timeStamp, this.fibNumbers);
    	
    	return resp;
    }
}
