package com.mj.pojos;

public class MainMenuSc {

		public static final void mainSc() {
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("||               ***MJ_Car Dealership***                 ||");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
		System.out.println("                 PLEASE SELECT AN OPTION                   ");
		System.out.print("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.print("\n||               1: View cars for sale                   ||");
		System.out.print("\n||               2: Customer Registration                ||");
		System.out.print("\n||               3: Search for a car                     ||");
		System.out.print("\n||               4: Login                                ||");
		System.out.print("\n||               5: Exit App                             ||");
		System.out.println("");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}
		
		public static void carListSc() { 
			System.out.println("Here is the list of cars for sale");
		}

		public static void customerRegSc() { 
			System.out.println("Please prepare to provide your information to open an account");	
		}
		
		public static void carSearchSc() { 
			
			System.out.print("Please provide the car infos: \n 1-: Car_Make \n 2-: Car_Model \n 3-: Year_Make");
			
		}
		
		public static void logginSc() { 
			
		System.out.print("Would you like to log as: \n 1-: EMPLOYEE \n 2-: Customer");
			
		}
}

