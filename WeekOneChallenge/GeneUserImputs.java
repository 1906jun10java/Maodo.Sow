
package com.rev.weekone.codechallenge;

import java.util.LinkedList;
import java.util.Scanner;

	public class GeneUserImputs extends BankFile {
		
		static Scanner sc = new Scanner(System.in);
		

	    static String charcomb = "ACGT";
		
			public static void userinput() {
				
				LinkedList<String> gl = new LinkedList<String>();
				LinkedList<String> Lbank = new LinkedList<String>();
				 
				System.out.println("choices from: \"A\", \"C\", \"G\", \"T\".");
				
				System.out.println("Please set the start Gene Combination of 8 characters");
				
					start = sc.nextLine();
					
					if (start.length() != 8) {
						
						System.out.println("The Gene Combination must be 8 characters");
						
						start = sc.nextLine();
					}
					else {
						for (int i = 0; i < 8; i++ ) {
							for (int j=0; j < 4; j++ ) {
							if (start.charAt(i) != charcomb.charAt(j)) {
								System.out.println("choices should be from: \"A\", \"C\", \"G\", \"T\".");
							}
							else 
							{
								continue;
							}
							}
						}	
						
						setStart(start);
						gl.add(getStart()); 
						Lbank.add(start);
						
						System.out.println("The start Gene Combination is: "+gl.indexOf(0));
					}
				
						for (int i = 1; i < nchoice; i++ ) {
							for (int j = 0; j < 8; j++) {
								gl.add(sc.next());
								
								Lbank.add(gl.get(i));
								
								if (i == nchoice - 1) {
									end = gl.peekLast();
								}
							}
						}
						System.out.println("This is our Gene Combination list: "+Lbank);
		}

	}
