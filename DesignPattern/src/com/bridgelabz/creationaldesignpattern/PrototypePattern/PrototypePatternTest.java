package com.bridgelabz.creationaldesignpattern.PrototypePattern;

import java.util.List;

public class PrototypePatternTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		Employees emps = new Employees();
		emps.loadData();
		//Now we have to clone the list to make changes..the changes will not be effected in the actual list
		Employees empsNew = (Employees) emps.clone();
		Employees empsNew1 = (Employees) emps.clone();
		List<String> list = empsNew.getEmpList();
		list.add("Yuga");
		List<String> list1 = empsNew1.getEmpList();
		list1.remove("Chaitra");
		System.out.println("Actual List: "+emps.getEmpList());
		System.out.println("List1: "+list);
		System.out.println("List2: "+list1);
	}

}
