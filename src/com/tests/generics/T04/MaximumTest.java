package com.tests.generics.T04;

//Determines the largest of three Comparable objects.
public class MaximumTest {

	public static void main(String args[]) {
		System.out.printf("Max of %d, %d and %d is: %d.\n\n", 3, 4, 5, maximum(3, 4, 5)); // Max of 3, 4 and 5 is: 5.
		
		System.out.printf("Max of %.1f, %.1f and %.1f is: %.1f.\n\n", 6.6, 8.8, 7.7, maximum(6.6, 8.8, 7.7)); // Max of 6,6, 8,8 and 7,7 is: 8,8.

		System.out.printf("Max of %s, %s and %s is: %s.\n", "pear", "apple", "orange", maximum("pear", "apple", "orange")); // Max of pear, apple and orange is: pear.
	}
	
	public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
		T max = x;  // Assume x is initially the largest.

		if (y.compareTo(max) > 0) {
			max = y;  // y is the largest so far.
		}

		if (z.compareTo(max) > 0) {
			max = z;  // z is the largest now.                 
		}
		
		return max;  // returns the largest object   
	}
}