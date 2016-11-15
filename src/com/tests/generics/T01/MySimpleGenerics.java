package com.tests.generics.T01;

public class MySimpleGenerics {

	public static void main(String a[]) {
		// We are going to create SimpleGeneric object with String as type parameter.
		SimpleGeneric<String> sgs = new SimpleGeneric<String>("TESTE");
		sgs.printType(); // Type: java.lang.String
		
		// We are going to create SimpleGeneric object with Boolean as type parameter.
		SimpleGeneric<Boolean> sgb = new SimpleGeneric<Boolean>(Boolean.TRUE);
		sgb.printType(); // Type: java.lang.Boolean
	}
}

/**
 * Here T is a type parameter, and it will be replaced with actual type when the object got created. 
 */
class SimpleGeneric<T> {
	// Declaration of object type T.
	private T objReff = null;

	// Constructor to accept type parameter T.
	public SimpleGeneric(T param) {
		this.objReff = param;
	}

	public T getObjReff() {
		return this.objReff;
	}

	// This method prints the holding parameter type.
	public void printType() {
		System.out.println("Type: " + objReff.getClass().getName());
	}
}