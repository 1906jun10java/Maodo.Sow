

import java.util.Scanner;

	public class ReverseString {
	
		static String str;
		static int n;
		static int i=0;
		static boolean paltest;
		static int test=0;
		static int ntest=0;
		static int choice;

		static Scanner sc = new Scanner(System.in);
		
			public static void main(String[] args) {
				
				System.out.println("Please provide your word");
					str = sc.nextLine();
			
				System.out.print("Please choose \n: 1- Reverse: \n 2- Palindrom: \n");
					choice = sc.nextInt();	
						if (choice == 1) {
							reverse(str);
						}
						else if (choice == 2) {
					
							palindrum(str);
				}
				else
					System.out.println("Unvalid entry");
			}
				
				
	
	public static void reverse(String str) {
		
		//assigning n to the length of the string to iterate from 0 to n

		n = str.length()-1;
		
			for(i = 0; i< n+1; i++) {
				
				// from every iteration we print out, remaining at the same line, the n-i character
				
				System.out.print(str.charAt(n-i));
				 	
			}
	}

	
		public static void palindrum(String str) {
			n = str.length();
			int t = (n-1)/2;
				if(n % 2 == 0) {
					for(i = 0; i<n/2; i++) {
						if (str.charAt(i) == str.charAt(n-i-1)) {
								paltest = true;	
								test+=1;
						}
						else 
							paltest = false;
							ntest+=1;
						}
						
					if (test == n/2) {
					System.out.print(str+ " is a palindrum");
					}
					else {
						System.out.print(str+ " is not a palindrum");
					}
				}
					else if(n % 2 != 0) {
						
					for(i = 0; i< t; i++) {
						if (str.charAt(i) == str.charAt(n-i-1)) {
							paltest = true;
							test+=1;
						}
						else {
							paltest = false;
							ntest+=1;
						}
					}
							if (test == t ) {
								System.out.print(str+ " is a palindrum");
							}
					
							else {
								System.out.print(str+ " is not a palindrum");
					}
					}
		}
	}
