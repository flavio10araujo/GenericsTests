package com.tests.generics.T01;

public class MySimpleTwoGenerics {

	public static void main(String a[]) {
		SimpleGen<String, Integer> sample = new SimpleGen<String, Integer>("TESTE", 100);
		sample.printTypes();
		// U Type: java.lang.String
		// V Type: java.lang.Integer
	}
}

/**
 * Simple generics class with two type parameters U, V. 
 */
class SimpleGen<U, V> {
	// Type U object reference.
	private U objUreff;
	// Type V object reference.
	private V objVreff;
	
	// Constructor to accept object type U and object type V.
	public SimpleGen(U objU, V objV) {
		this.objUreff = objU;
		this.objVreff = objV;
	}
	
	public void printTypes() {
		System.out.println("U Type: " + this.objUreff.getClass().getName());
		System.out.println("V Type: " + this.objVreff.getClass().getName());
	}
}