package com.mj.carservices;

import java.util.Scanner;

import com.mj.pojos.AllCarsView;
import com.mj.users.CustomerOffer;
import com.mj.utility.MainMenu;
import com.mj.utility.UserInputs;
import com.mj.users.CustomerOffer;;

	public class EmployeScreen implements  emptasksInterface {
	
	static Scanner sc = new Scanner(System.in);
	static int choice;
		
		public static void showempaccount() {
			
			System.out.print("\n 1: Create an offer \n 2: view existing offer \n 3: Add new car \n 4: Delete a car");
			choice = sc.nextInt();
			
			switch (choice) {
			
			case 1 :
				System.out.println("You are creating a new offer: ");
				System.out.println(" ");
				System.out.println("You are creating a new offer ");
				System.out.println(" ");
				
				System.out.println("New offer created ");
	
				break;
		
			case 2:
				System.out.println("You are viewing the list of existing offers ");
			
				//Customers.createcustomer();
				break;
			case 3 :
				System.out.println("You are adding a car ");
				System.out.println(" ");
				
				break;
		
			case 4:
				System.out.println("You are deleting a car ");
				System.out.println(" ");
			default:
			{ 
				System.out.println("!!! Good Bye");
			}
			MainMenu.menu1();
			UserInputs.userprompt();
			}
		}
	/*
	 * public static void createoffer() {
	 * 
	 * System.out.println("You are creating a new offer "); System.out.println(" ");
	 * 
	 * System.out.println("New offer created "); }
	 */
				

}