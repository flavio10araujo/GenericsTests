package com.tests.generics.T03;

import java.util.Arrays;
import java.util.List;

// Wildcards
public class BMain {

	public static void main(String[] args) {
		List<Integer> li = Arrays.asList(1, 2, 3);
		List<String>  ls = Arrays.asList("one", "two", "three");
		
		//printList1(li); // erro de compilação
		//printList1(ls); // erro de compilação
		
		printList2(li); // ok
		printList2(ls); // ok
	}
	
	/**
	 * The goal of printList is to print a list of any type, but it fails to achieve that goal — it prints only a 
	 * list of Object instances; it cannot print List<Integer>, List<String>, List<Double>, and so on, because they 
	 * are not subtypes of List<Object>. 
	 */
	public static void printList1(List<Object> list) {
	    for (Object elem : list)
	        System.out.println(elem + " ");
	    System.out.println();
	}
	
	/**
	 * Because for any concrete type A, List<A> is a subtype of List<?>, you can use printList to print a list of any type.
	 */
	public static void printList2(List<?> list) {
	    for (Object elem: list)
	        System.out.print(elem + " ");
	    System.out.println();
	}
}