package com.guru.practice;

public class Employee {
	String name;
	int id;
	Adress adress;
	String department;
	
	public Employee(String name, int id, Adress adress, String department) {
		super();
		this.name = name;
		this.id = id;
		this.adress = adress;
		this.department = department;
	}

	public Employee() {
		super();
	}

	@Override
	public boolean equals(Object o) {
		if(o instanceof Employee)
		{
			Employee e=(Employee) o;
			if(this.name.equals(e.name)&&this.id==e.id&&this.department.equals(e.department)&&this.adress.equals(e.adress))
				return true;
			else
				return false;
		}
		else
			throw new IllegalArgumentException("Employees ashte compare madbeku");
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return (this.adress+this.department+this.id+this.name).hashCode();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ("Name: "+this.name+" id: "+this.id+" adress: "+this.adress+" department: "+this.department);
	}
	
	
}
