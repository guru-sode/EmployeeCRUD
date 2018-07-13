package com.guru.practice;

import java.util.HashSet;

public class TestEmployee {

	public static void main(String[] args) {
		Adress a1=new Adress("Bengaluru", 8, "Jayanagar", 560011);
		Employee e1=new Employee("Guru", 820541, a1, "Simulators");
		Adress a2=new Adress("Bengaluru", 8, "Jayanagar", 560011);
		Employee e2=new Employee("Guru", 820541, a2, "Simulators");
		Adress a3=new Adress("Kadapa", 8, "Andhra", 577430);
		Employee e3=new Employee("Saikiran", 820542, a3, "Simulators");
		Adress a4=new Adress("Ibm", 9, "Vizag", 577401);
		Employee e4=new Employee("Saikumar", 820543, a4, "Simulators");
		HashSet<Employee> hashset=new HashSet<Employee>();
		hashset.add(e1);
		System.out.println(hashset.add(e2));
		hashset.add(e3);
		hashset.add(e4);
		System.out.println(hashset);
		
	}

}
