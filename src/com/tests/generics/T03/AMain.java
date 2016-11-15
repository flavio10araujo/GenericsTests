package com.tests.generics.T03;

import java.util.Arrays;
import java.util.List;

// Wildcards
public class AMain {

	public static void main(String[] args) {
		List<Integer> li = Arrays.asList(1, 2, 3);
		System.out.println("sum = " + sumOfList(li)); // sum = 6.0
		
		List<Double> ld = Arrays.asList(1.2, 2.3, 3.5);
		System.out.println("sum = " + sumOfList(ld)); // sum = 7.0	
	}
	
	public static double sumOfList(List<? extends Number> list) {
	    double s = 0.0;
	    
	    for (Number n : list)
	        s += n.doubleValue();
	    
	    return s;
	}
}