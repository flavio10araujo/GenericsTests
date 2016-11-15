package com.tests.generics.T01;

import java.util.ArrayList;
import java.util.List;

public class AMain {

	public static void main(String[] args) {
		// A partir do Java 7 é possível usar o símbolo diamond:
		List<Integer> teste = new ArrayList<>();
		// Ou seja, não tem mais necessidade de fazer assim:
		// List<Integer> teste = new ArrayList<Integer>();
		
		// ##################################################
		SimpleBox simpleBox = new SimpleBox();
		
		GenericBox genericBox = new GenericBox(); // Pode ser chamado assim, mas não é recomendado.
		
		GenericBox<Integer> genericBox2 = new GenericBox<>(); // Usando o símbolo diamond.
		
		GenericBox<Integer> genericBox3 = new GenericBox<Integer>();
		
		// ##################################################
		BoxBounded<Integer> boxBounded = new BoxBounded<>();
		
		//BoxBounded<String> boxBounded2 = new BoxBounded<>(); // erro de compilação pois BoxBounded só permite objetos que extendem a classe Number.
	}
}

// Não usa generic.
class SimpleBox {
	private Object object;
	
	public void set(Object object) {
		this.object = object;
	}
	
    public Object get() { 
    	return object; 
    }
}

// Class usando generic type.
class GenericBox<T> {
	private T t;
	
	public void set(T t) {
		this.t = t;
	}
	
	public T get() {
		return t;
	}
}

// Class com generic method.
class GenericMethod {
	
	public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
        
		return p1.getKey().equals(p2.getKey()) && p1.getValue().equals(p2.getValue());
    }
}

class Pair<K, V> {

    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public void setKey(K key) { this.key = key; }
    public void setValue(V value) { this.value = value; }
    public K getKey()   { return key; }
    public V getValue() { return value; }
}

// Class com bounded type parameter.
class BoxBounded<T extends Number> {
private T t;
	
	public void set(T t) {
		this.t = t;
	}
	
	public T get() {
		return t;
	}
	
	// In addition to limiting the types you can use to instantiate a generic type, bounded type parameters allow you to invoke methods defined in the bounds:
	public boolean isEven() {
		return t.intValue() % 2 == 0;
	}
}