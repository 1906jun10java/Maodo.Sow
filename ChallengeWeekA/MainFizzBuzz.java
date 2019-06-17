import java.util.Scanner;
	
	public class MainFizzBuzz {
	

		static FizzBuzz F1 = new FizzBuzz();
		
		
		static Scanner S = new Scanner(System.in);
		public static int choice;
		
		static int[] transnum; 
		String[] transterms;
		static int lg=0;
		int indexterm =0;
		int count = 0;
		static int m=0;
		static int n=0;
		static int i= 0;
		static int t=0;
		
		static int[] num;
		static String[] terms;
		
		public static void main(String[] args) {
			System.out.print("Please your Fizz buzz type: \n 1- fizzBuzzBasic. \n 2 fizzBuzzBasicAdvanced ");
			choice = S.nextInt();
			if (choice == 1) {
				F1.fizzBuzzBasic();
			}
			else if (choice == 2) {
				
				System.out.println("Please enter  the starting point");
				m = S.nextInt();

				System.out.println("Please enter the end point");
				n = S.nextInt();
				
					if (m>n) { 
						System.out.println("Please reenter the end point! should be greater or equal to"+m);
						n = S.nextInt();
					}
					else {
				
					System.out.println("Please choose your Array size");
					lg = S.nextInt();
					num = new int [lg];
					terms = new String[lg];
					
					System.out.println("Please file out your array numbers");
					for (i=0; i<lg; i++) {
						System.out.println("Please provide the " +i+1+ "th number");
						num[i] = S.nextInt();
						}
					
					System.out.println("Please file out your array terms");
					for (i=0; i<lg; i++) {
						System.out.println("Please provide the " +i+1+ "th term");
						terms[i] = S.nextLine();
						}
							for (t =0; t < lg; 	t++) {
								if (num[t] == lg) {
									transnum[t] = num[lg];
						  }

					F1.fizzBuzzAdvanced(m, n, num, terms);

			}
	
		}
		
	}
	}
	}



