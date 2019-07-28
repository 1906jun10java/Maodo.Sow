package com.ms.services;

import java.sql.SQLException;
import java.util.Scanner;

import com.ms.daos.EmployeeDaoImpl;

public class Tasks {
	
	private static String fname;
	private static String lname;
	private static double sal;
	private static String email;
	private static int did;
	
	static Scanner s = new Scanner(System.in);

		public static Employee empinput() {
		
			Employee e = new Employee();
			
		System.out.println("Please enter your firstname,");
		System.out.println(">>>");
		fname =s.nextLine();
		e.setFirstname(fname);
		System.out.println("Please enter your lastname,");
		System.out.println(">>>");
		lname = s.nextLine();
		e.setLastname(lname);
		System.out.println("Please enter the employee department ID,");
		System.out.println(">>>");
		did =s.nextInt();
		e.setDep_id(did);
		System.out.println("Please enter the employe salary,");
		System.out.println(">>>");
		sal = s.nextDouble();
		e.setSalary(sal);
		System.out.println("Please enter the employe email");
		System.out.println(">>>");
		email = s.nextLine();
		e.setEmail(email);
		return e;
		
	}

}
