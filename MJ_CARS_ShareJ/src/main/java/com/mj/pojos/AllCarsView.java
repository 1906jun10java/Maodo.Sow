package com.mj.pojos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mj.daos.carDaoImpl;
import com.mj.users.Cars;
import com.mj.utility.UserInputs;
import java.util.Scanner;

	public class AllCarsView {
		
		
		
		public static void displayCars() { 
	
			carDaoImpl c = new carDaoImpl ();

			try {
				ArrayList<Cars> test = c.getAllCars();
				for (Cars ca: test) {
					System.out.println(ca);
				}
				UserInputs.userOption();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		static Scanner sc = new Scanner(System.in);
		public static int vinlooker() {
			int choice;
			choice = sc.nextInt();
			//System.out.println(choice);
			return choice;
		}
		
		
		
		
		public static void displayCarsFound() { 
			int choice;
			
			carDaoImpl c = new carDaoImpl ();
			System.out.println("Please enter your VIN");
			choice = sc.nextInt();

			try {
				
				List<Cars> test = c.getCarByVIN(choice);
				for (Cars ca: test) {
					System.out.println(ca);
				}
				UserInputs.userOption();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

}
