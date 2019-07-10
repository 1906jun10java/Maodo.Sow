package com.mj.pojos;

import java.util.Scanner;

import com.mj.users.Customers;

public class UserSelection {

	private static Scanner sc = new Scanner(System.in);

	private static UserSelection instance;

	static String username;
	static String password;

	// Static method to get the unique instance- if it does not exist
	// we will create it
	public static synchronized UserSelection getInstance() {

		if (instance == null) {
			instance = new UserSelection();
		}
		return instance;

	}

	public void userprompt() {
		int choice;
		choice = sc.nextInt();
		while (choice < 1 || choice > 5) {
			System.out.println("!!!Invalid entry: please try again,");
			choice = sc.nextInt();
		}

		switch (choice) {

		case 1:
			System.out.println("Here is the list of cars available for sale: ");
			// Diplay all available cars for sale by selecting all cars where status != not
			// actif

			break;

		case 2:
			System.out.println("Please enter your information ");

			// Customers.createcustomer();
			break;

		case 3:

			System.out.println("Please provide the car specifications ");
			break;

		case 4:

			System.out.print("Would you like to log as \n 1:Employee or as \n 2: Customer? ");

			break;

		case 5:
			System.out.println("Thank you for visiting MJ_CarDealership ");
			break;

		default: {
			System.out.println("Next time");
		}
			sc.close();
		}

	}

}
