package com.ms.services;

import java.sql.SQLException;
import java.util.Scanner;

import com.ms.daos.EmployeeDaoImpl;
import com.ms.daos.MyDbconnectDaoImpl;

public class MenuDisplay {
	
	
	public static void userOption() {
		
		EmployeeDaoImpl empdao = new  EmployeeDaoImpl();
		
		MyDbconnectDaoImpl dbdao = new  MyDbconnectDaoImpl ();
		Scanner sc = new Scanner(System.in);
		int ch;
		System.out.print("\nPlease press 1- Connect my database Week2CDB");
		
		System.out.print("\nPlease press 2- Print Department name and Average salary");
		
		System.out.print("\nPlease press 3- Insert Employee");
		
		System.out.println("\nOr press 4 : to Exit program");
		
		ch = sc.nextInt();
		while (ch < 1 || ch > 5) {
			System.out.println("!!!Invalid entry: please try again,");
			System.out.println(">>>");
			ch = sc.nextInt();
		}

		switch (ch) {

		case 1:
			System.out.println("You are connecting to Week2CDB database: ");
			dbdao.connectdb();
			break;
			
		case 2:
			System.out.println("You are connecting to Week2CDB database: ");
			//MyDbconnectDaoImpl.connectdb();
			break;
			
		case 3:
			System.out.println("You are about to insert a new Employe: ");
			try {
				empdao.insertEmployee();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		default: {
			System.out.println("Next time");
		}
			sc.close();
			System.out.println("!!! Good Bye");
		}
	}
}
