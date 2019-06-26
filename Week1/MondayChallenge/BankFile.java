package com.rev.weekone.codechallenge;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

	public class BankFile extends CharactersComb{

		public static String start;
		public static String end;
		public static int nchoice;
		public static int numchange=0;
		public static String charcomb ="ACGT";
		public static int charcount = 0;
		
		static LinkedList<String> Lbank = new LinkedList<String>();

			public static int  numbcombination() {
		
				Scanner sc = new Scanner(System.in);
				System.out.println("Please provide the number of Gene Combination");
				nchoice = sc.nextInt(); 
				return nchoice;
				}
			
				public static void geneentry() {
				
					//proceeding to the combination letters validation
					// checking if the requirement of only "A, C, G, T",  is respected
					Scanner sc = new Scanner(System.in);
					System.out.println("choices from: \"A\", \"C\", \"G\", \"T\".");
					System.out.println("-------------------------------------------");
					
					for (int i = 0; i < nchoice; i++ ) {
						System.out.println("Please enter the gene combination number: "+i);
						Lbank.add(sc.nextLine());
					}
					for (int i = 0; i < nchoice; i++ ) {
						//Calling the validation methods from CharactersComb class.
						// All combination will be checked depending of the user number of choice "nchoice".
						charcombinationchecker(Lbank.get(i));
							if(CharactersComb.count == 8) {
								charcount = charcount + 1;
							}
							else charcount = charcount - 1;
					}
					if (charcount == nchoice) {
							start = Lbank.getFirst();
							end = Lbank.getLast();
							System.out.println("----------Our filled list of Genes Combination");
							System.out.println(Lbank);
					}
					else System.out.println("Unvlid character entry");
							
				}
				
				
				public static void genevalidation() {
					
					for (int i = 0; i <nchoice; i++) {
						if ( Lbank.get(i).length() != 8) {
						System.out.println("The Gene Combination must be 8 characters");
						
						geneentry();
						}
					}
				}
				
				public static int recordchange() {
					
							for (int i = 1; i < nchoice; i++ ) {	
								if(Lbank.get(0).compareTo((Lbank.get(i))) == 0 )   {
									numchange = numchange; 
								}
								else {
								numchange = numchange + 1;
								}
							}
						System.out.println("The number of changes occured with Gene Combination is: "+numchange);
						System.out.println(Lbank);
						return numchange;
						
				}
	}
	

