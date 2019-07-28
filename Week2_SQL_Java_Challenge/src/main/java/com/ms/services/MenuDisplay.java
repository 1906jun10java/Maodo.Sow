package com.ms.services;

import java.sql.SQLException;
import java.util.Scanner;

import com.ms.daos.DepartmentDaoImpl;
import com.ms.daos.EmployeeDaoImpl;

public class MenuDisplay {
	
	
	public static void userOption() {
		Scanner sc = new Scanner(System.in);
		int ch;
		EmployeeDaoImpl ed = new EmployeeDaoImpl();
		DepartmentDaoImpl dd = new DepartmentDaoImpl();
		
		System.out.println("===============================================");
		System.out.print("\n Please press 1- Print Department name");
		System.out.print("\n Please press 2- Average salary");
		System.out.print("\n Please press 3- Insert Employee");
		System.out.print("\n Please press 4- View All Employees");
		System.out.println("\n Or press  :5 Exit program");
		
		ch = sc.nextInt();
		while (ch < 1 || ch > 5) {
			System.out.println("!!!Invalid entry: please try again,");
			System.out.println(">>>");
			ch = sc.nextInt();
		}

		switch (ch) {

		case 1:
			System.out.println("Here are the existing depanament: ");
			try {
				dd.getDepartmentList();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			MenuDisplay.userOption();
			break;
			
		case 2:
			System.out.println("Here is the Average Salary by Department: ");
			try {
				ed.AverageByDep();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			MenuDisplay.userOption();
			
			break;
			
		case 3:
			System.out.println("Creating a new Employee: ");
		
			EmployeeDaoImpl empdao = new  EmployeeDaoImpl();
			try {
				empdao.createNewEmployee(Tasks.empinput());
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
				System.out.println("Employee successfully created");
			System.out.println("========================================================");
				MenuDisplay.userOption();
			
			break;
			
		case 4:
			System.out.println("Here is the List of all Employees: ");
		
			try {
				ed.getEmployeeList();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				MenuDisplay.userOption();
			
			break;
			
		case 5: {
			System.out.println("Next time");
		}
			sc.close();
			System.out.println("!!! Good Bye");
		}
	}
}
