package com.mj.carservices;

import java.sql.SQLException;
import java.util.Scanner;

import com.mj.daos.carDaoImpl;
import com.mj.daos.customerDaoImpl;
import com.mj.users.CustomerOffer;
import com.mj.users.Customers;
import com.mj.utility.MainMenu;
import com.mj.utility.UserInputs;

public class CustomerScreen {
	static Scanner sc = new Scanner(System.in);
	
	static Customers c = new Customers(0, null, null, null, null, null);
	
	public static void ccount() {
		
		
		System.out.println("Please enter your firstname,");
		System.out.println(">>>");
		c.setFirstname(sc.nextLine());
		
		System.out.println("Please enter your lastname,");
		System.out.println(">>>");
		c.setLastname(sc.nextLine());
		
		System.out.println("Please enter your email address,");
		System.out.println(">>>");
		c.setCustemail(sc.nextLine());
		
		System.out.println("Please enter your username,");
		System.out.println(">>>");
		c.setCustusername(sc.nextLine());
		
		System.out.println("Please enter your password,");
		System.out.println(">>>");
		c.setCustpw(sc.nextLine());

		System.out.println("Custumer successfully created");

		MainMenu.menu1();
		System.out.println(">>>");
		UserInputs.userprompt();
		
	}
}

/*
 * customerDaoImpl ce= new customerDaoImpl();
 * 
 * try { ce.createcustomer(c); } catch (SQLException e) { // TODO Auto-generated
 * catch block e.printStackTrace();
 */




			


