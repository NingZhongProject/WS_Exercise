package com.exercise.services;

/**
 * This is a utility class that defines some common functions used by the services.
 * The purpose is to separate the actual function from the service classes. Over the 
 * years when the system evolves, we may need to consider introducing other algorithms to
 * compute the numbers. For example, when a large number of incoming requests given a fairly
 * large number n, we may choose to put a large number of first Fib numbers in one single share 
 * storage space which all service request can access and retrieve the already calculated numbers,
 * instead of calculating them each time a service is invoked. This way we can balance between 
 * computational complexity and space complexity.
 */
public class ServiceHelper {
	public static long [] obtainFirstNFibNumbers(int n) {
		if (n <= 0) {
			return null;
		}
		
		if (n == 1) {
			return new long[]{0};
		}
		
		long [] nums = new long[n];
		
		nums[0] = 0;
		nums[1] = 1;
		
		for (int i=2; i<n; i++) {
			nums[i] = nums[i-2] + nums[i-1];
		}
		
		return nums;
	}
}
