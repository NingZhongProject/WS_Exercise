package com.exercise.services;

/**
 * This is a utility class that defines some common functions used by the services.
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
