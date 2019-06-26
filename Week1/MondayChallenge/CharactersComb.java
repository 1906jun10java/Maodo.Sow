package com.rev.weekone.codechallenge;

public class CharactersComb {

	public static String comb = "ACGT";
	public static int count = 0;
	
	public static void main(String[] args) {
		
		charcombinationchecker("AAAAAAAP");
	}
	
	
	public static int charcombinationchecker(String str) {
		
		
			for (int j = 0; j < 8; j++) {
					if(comb.indexOf(str.charAt(j)) ==-1 ){
						count = count - 1;
					}
					else count = count + 1;
					}
			
			if(count == 8) {
			System.out.println("Good characters choice");
			} 
			else if (count !=8) {
			 System.out.print("Unvalid characters choice");
			}
			return count;
	}

}
