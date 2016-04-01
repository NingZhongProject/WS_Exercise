package com.exercise.test;

import org.junit.Test;
import org.junit.Assert;

import com.exercise.services.ServiceHelper;

/**
 * Unit test for the helper class.
 */
public class ServiceHelperTest {
	public static void main(String[] args) {
	}
	
	/**
	 * Test case when the given number is larger than or equal to 2.
	 */
	@Test
	public void testObtainFirstNFibNumbers1() {
		Assert.assertArrayEquals(ServiceHelper.obtainFirstNFibNumbers(7), new long[]{0,1,1,2,3,5,8});
	}
	
	/**
	 * Boundary test case ... when the given number is smaller than 2.
	 */
	@Test
	public void testObtainFirstNFibNumbers2() {
		Assert.assertArrayEquals(ServiceHelper.obtainFirstNFibNumbers(0), null);
	}
}
