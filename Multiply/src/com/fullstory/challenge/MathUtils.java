package com.fullstory.challenge;
import java.util.Arrays;

public class MathUtils {

	public static void main(String[] args) {
		
		System.out.println(MathUtils.Multiply(-25, -2));
		System.out.println(MathUtils.Multiply(25, -2));
		System.out.println(MathUtils.Multiply(25, 2));
		System.out.println(MathUtils.Multiply(-25, 2));
		System.out.println(MathUtils.Multiply(0, 2));

	}
	
	/**
	 * Elegant 
	 */
	public static int Multiply(int v1, int v2) {
		
		//
		// multiplication is adding one number as many times as the value of the second number
		//
		
		// create and fill array with v1
		Integer arr[] = new Integer[Math.abs(v2)];
		Arrays.fill(arr, v1);
		
		// add the values in the array
		int res = Arrays.asList(arr).stream().reduce(0, (x, y) -> x + y);
		
		// account for negative
		res = v2 < 0 ? 0 - res : res;
		
		return res;
	}
	
	/**
	 * Brute force approach
	 * 
	 */
	public static int Multiply2(int v1, int v2) {
		
		int res = 0;
		// detect if result will be negative
		boolean negate = false;
		if (v1 < 0 && v2 > 0 || v1 > 0 && v2 < 0) {
			negate = true;
		}
		
		// stay positive :)
		v1 = Math.abs(v1);
		v2 = Math.abs(v2);
		
		for (int i=0; i<v2; i++) {
			res += v1;
		}
		
		if (negate) {
			res = 0 - res;
		}
		return res;
	}

}
