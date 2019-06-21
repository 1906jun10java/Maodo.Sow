package com.revature.reverse;

import java.util.Scanner;


public class SubStringChecker {
	
	static boolean sbstest;
	static String lgstr;
	static String cstr;
	static int numrows;
	static int nblocks;
	
	static int choice;

	static Scanner sc = new Scanner(System.in);

	
	public static void main(String[] args) {
		
		System.out.print("Please choose \n: 1- SubString: \n 2- Triangle Blocks: \n");
			choice = sc.nextInt();	
			
				if (choice == 1) {
		
						userstring();
						subString(lgstr,cstr);
		
			} 
				else if (choice == 2) {
					System.out.println("Please provide the number of rows");
					numrows = sc.nextInt();
					System.out.println("The number of rowas for this triangle is: "+triangle(numrows)); 		 
				}
}
		public static void userstring() {
		
		System.out.println("Please provide the 1st string");
			lgstr = sc.nextLine();
				System.out.print("\n");
				
				if(lgstr.length() >= 1) {
					
					System.out.println("Please provide the substring searching for");
					cstr = sc.nextLine();
				}
				else userstring();
		}
		
		public static boolean subString(String lgstr, String cstr) {
			
			if (lgstr.contains(cstr) == true) {
				sbstest = true;
				System.out.println(cstr+ " is a substring of " +lgstr);
			}
			else {
				System.out.println(cstr+ " is not a substring of " +lgstr);
				sbstest = false;
			}
				return sbstest;
		}
		
		
		public static int triangle(int numrows) {
	         if(numrows >= 1) {
		nblocks = numrows + triangle(numrows -1);
	         }
			
	      return nblocks;
}


}
