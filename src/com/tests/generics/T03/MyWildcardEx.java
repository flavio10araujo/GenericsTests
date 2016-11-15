package com.tests.generics.T03;

public class MyWildcardEx {
	
	public static void main(String a[]) {

		MyEmployeeUtil<CompAEmp> empA = new MyEmployeeUtil<>(new CompAEmp("Maria", 20000));

		MyEmployeeUtil<CompBEmp> empB = new MyEmployeeUtil<>(new CompBEmp("Carolina", 30000));

		MyEmployeeUtil<CompAEmp> empC = new MyEmployeeUtil<>(new CompAEmp("Natasha", 20000));
		
		// Usando wildcard. 
		System.out.println("Is salary same? " + empA.isSalaryEqual(empB)); // Is salary same? false
		System.out.println("Is salary same? " + empA.isSalaryEqual(empC)); // Is salary same? true
		
		// System.out.println("Is salary same? " + empA.isSalaryEqual2(empB)); // Erro de compilação.
		System.out.println("Is salary same? " + empA.isSalaryEqual2(empC)); // Is salary same? true
	}
}

class MyEmployeeUtil<T extends Emp> {
	private T emp;

	public MyEmployeeUtil(T obj) {
		emp = obj;
	}

	public int getSalary() {
		return emp.getSalary(); // Só é possível chamar o getSalary aqui porque T extends Emp.
	}

	public boolean isSalaryEqual(MyEmployeeUtil<?> otherEmp) {
		if (emp.getSalary() == otherEmp.getSalary()) {
			return true;
		}

		return false;
	}
	
	// This logic won't work.
	// Because once you create an object of MyEmployeeUtil class, the type argument will be specific to an instance type.
	// So you can compare between only same object types, ie, you can compare either objects of CompAEmp or CompBEmp, but not between CompAEmp and CompBEmp.
	public boolean isSalaryEqual2(MyEmployeeUtil<T> otherEmp) {
	    if (emp.getSalary() == otherEmp.getSalary()) {
	        return true;
	    }
	    
	    return false;
	}
}

class Emp {
	private String name;
	private int salary;

	public Emp(String name, int sal) {
		this.name = name;
		this.salary = sal;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
}

class CompAEmp extends Emp {
	public CompAEmp(String nm, int sal) {
		super(nm, sal);
	}
}

class CompBEmp extends Emp {
	public CompBEmp(String nm, int sal){
		super(nm, sal);
	}
}