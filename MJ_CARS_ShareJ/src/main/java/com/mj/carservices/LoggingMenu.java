package com.mj.carservices;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mj.users.Cars;
import com.mj.users.Employees;
import com.mj.utility.ConnectionService;

public class LoggingMenu {

	public static ConnectionService cf = ConnectionService.getInstance();

	private static String username;
	private static String password;
	private static int ch1;

	static Scanner sc = new Scanner(System.in);
	/* int choice; */

	public static boolean loggingoption(int ch) {
		boolean validation = false;
		if (ch == 1) {
			validation = true;
			employeelogging();
		} else if (ch == 2) {
			validation = true;
			customerlogging();
		} else {
			validation = false;
			System.out.println("!!!!Unvalid Entry");
		}

		// try {

		return validation;
	}

	public static void employeelogging() {
		String u, p;
		System.out.println("Please provide your username");
		System.out.println(">>>");
		username = sc.nextLine();

		System.out.println("Please provide your password");
		System.out.println(">>>");
		password = sc.nextLine();

		Connection conn = cf.getConnection();
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		try {
			ResultSet rs = stmt.executeQuery("SELECT EMP_USERNAME, EMP_PASSWORD FROM EMPLOYEES ");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		Employees e = null;
		u = e.getEmpusername();
		p = e.getEmppw();
		if (u == username && p == password) {
			System.out.println("Logging Successes");
			EmployeScreen.showempaccount();
		}

	}

	public static void customerlogging() {
		System.out.println("Please provide your username");
		System.out.println(">>>");
		username = sc.nextLine();

		System.out.println("Please provide your password");
		System.out.println(">>>");
		password = sc.nextLine();
	}

}
