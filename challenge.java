	public class Challenge {
	
		static String str;
		static String revs;
		static char[] revc;
		static int n;
		static char char1;
		static int i=0;
		static boolean paltest;
		static int test=0;
		static int ntest=0;

			public static void main(String[] args) {
		
				//reverse("MANIPULATIONS");
				palindrum("ATTA");

			}

	
	public static void reverse(String str) {
		
		n = str.length()-1;
		
			for(i = 0; i< n+1; i++) {
				
				System.out.print(str.charAt(n-i));
				 	
			}
	}

	
		public static void palindrum(String str) {
		
			n = str.length();
			int t = (n-1)/2;
			
				if(n % 2 == 0) {
					
					for(i = 0; i< n; i++) {
						
						if (str.charAt(i) == str.charAt(n-i-1)) {
								paltest = true;	
								test++;
						}
						else 
							paltest = false;
							test = test;
						}
					
						
					if (test == n/2) {
					System.out.print(str+ " is a palindrum");
					}
					else {
						System.out.print(str+ " is not a palindrum");
					}
					
				}
					else if(n % 2 != 0) {
						
					for(i = 0; i< n-1; i++) {
						if (str.charAt(i) == str.charAt(n-i-2) && i!=t) {
							paltest = true;
							test++;
						}
						else {
							paltest = false;
							test = test;
						}
					}
							if (test == (n-1)/2 ) {
								System.out.print(str+ " is a palindrum");
							}
					
							else {
								System.out.print(str+ " is not a palindrum");
					}
					}
		}
	}

