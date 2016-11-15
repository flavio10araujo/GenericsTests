package com.tests.generics.T02;

public class MyBoundedClassEx {

	public static void main(String a[]) {
		// Creating object of sub class C and passing it to BoundEx as a type parameter.
		BoundEx<C> bec = new BoundEx<>(new C());
		bec.doRunTest(); // I am in sub class C.
		
		// Creating object of sub class B and passing it to BoundEx as a type parameter.
		BoundEx<B> beb = new BoundEx<>(new B());
		beb.doRunTest(); // I am in sub class B.

		// Similarly passing super class A.
		BoundEx<A> bea = new BoundEx<>(new A());
		bea.doRunTest(); // I am in super class A.
		
		// If you uncomment below code it will throw compiler error because we restricted to only of type A and its sub classes.
		// BoundEx<String> bes = new BoundEx<String>(new String());
		// bea.doRunTest();
	}
}

/**
 * This class only accepts type parameters as any class which extends class A or class A itself.
 * Passing any other type will cause compiler time error.
 */
class BoundEx<T extends A> {

	private T objRef;

	public BoundEx(T obj) {
		this.objRef = obj;
	}

	public void doRunTest() {
		this.objRef.printClass(); // Posso chamar o método printClass porque T extends A então tenho certeza que qualquer T tem esse método implementado.
	}
}

class A {
	public void printClass() {
		System.out.println("I am in super class A.");
	}
}

class B extends A {
	public void printClass(){
		System.out.println("I am in sub class B.");
	}
}

class C extends A {
	public void printClass() {
		System.out.println("I am in sub class C.");
	}
}