package com.exercise.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.InvalidRequestParameterException;
import com.exercise.services.FabonacciService;

import com.exercise.services.ServiceResponse;

/**
 * This is the controller for the Fabonacci service, which returns the first n 
 * Fabonacci numbers.
 */
@RestController
public class FabonacciServiceController {

	/**
	 * A different URI pattern
    @RequestMapping("/fabonacci")
    public ServiceResponse fabonacci(@RequestParam(value="n", defaultValue="0") String n) {
    */
	
	@RequestMapping(value = "/fabonacci/{n}", method = RequestMethod.GET)
    public ServiceResponse fabonacci(@PathVariable String n) {

    	// First make sure the input is a valid number ... expecting an long number
    	int inNum = Integer.parseInt(n);
    	
    	// Here a negative number is considered an invalid request and an exception
    	// is raised. Alternately, we may also return ServiceRepose object with "note" field
    	// set as "invalid input" to indicate an abnormal condition.
    	if (inNum < 0) {
    		throw new InvalidRequestParameterException();
    	}
    	
    	FabonacciService service = new FabonacciService(inNum);
    	service.obtainFibNumbers();
    	
        return service.obtainResponse();
    }
}