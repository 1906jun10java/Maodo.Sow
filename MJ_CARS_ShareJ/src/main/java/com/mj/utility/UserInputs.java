package com.mj.utility;


	import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.mj.carservices.CustomerScreen;
import com.mj.carservices.LoggingMenu;
import com.mj.daos.carDaoImpl;
import com.mj.daos.customerDaoImpl;
import com.mj.pojos.AllCarsView;
import com.mj.users.Cars;
	import com.mj.users.Customers;
	

	public class UserInputs {
		
		private static Scanner sc = new Scanner (System.in);
		//static int ch1;
		private static UserInputs instance;

		private UserInputs() {
		
		}
		 
		//Static method to get the unique instance- if it does not exist
		//we will create it
		public static synchronized UserInputs getInstance() {
			
		if(instance==null) {
		instance= new UserInputs();
		}
		return instance;

		}
		
		public static void userOption() {
			int ch;
			System.out.println("Please press 1- back to the Main Menu");
			System.out.println("Or press 2 : to Exit program");
			ch = sc.nextInt();
			System.out.println(">>>");
			if (ch == 1) { 
			MainMenu.menu1();
			userprompt();
			}
			else if (ch==2) {
				System.out.println("!!! Good Bye");
				System.out.println("Thanks for vsiting MJ_CAR_DEALERSHIP");
				sc.close();
			}
			else { 
				System.out.println("!!! Invalid entry");
			MainMenu.menu1();
			userprompt();
			}
		}
			
		
		public static void userprompt() {
			int choice;
			choice = sc.nextInt();
			System.out.println(">>>");
			while (choice < 1 || choice > 5) {
				System.out.println("!!!Invalid entry: please try again,");
				System.out.println(">>>");
				choice = sc.nextInt();
				
			}

			switch (choice) {
		
			case 1 :
				System.out.println("Here is the list of cars available for sale: ");
				System.out.println(" ");
				AllCarsView.displayCars();
	
				break;
		
			case 2:
				System.out.println("Please enter your information ");
			
				customerDaoImpl c = new customerDaoImpl ();
				CustomerScreen.ccount();
				break;
				
			case 3:
				
				AllCarsView.displayCarsFound();
				
				break;
				
			case 4:
				
				System.out.print("Would you like to log as \n 1:Employee or as \n 2: Customer? ");
				choice = sc.nextInt();
				LoggingMenu.loggingoption(choice);
				
				break;
				
			case 5:
				System.out.println("Thank you for visiting MJ_CarDealership ");
				sc.close();
				break;
				
			default:
			{ 
				System.out.println("Next time");
			}
			sc.close();
			}
				

	}

}
