package basic;

import java.lang.Math;

/**
 * This class used for first lession
 * 
 * @author Mai Van Ha
 * 
 */

public class HelloWorld {
	// Main function called by JVM when execute program from this class.
	public static void main(String[] args) {
		System.out.println("Hello World ! Welcome to \"JWF0825\"");
		String str1 = "Hello ";
		String str2 = "World";
		System.out.print(str1);
		System.out.print(str2);
		
		System.out.println(str1);
		System.out.println(str2);
		
		int a = 1; 
		int b = a ++; 
		int c = ++ a;
		
//		a = a + 5; // a += 5
//		
//		boolean b1 = true; 
//		boolean b2 = true;
//		if ( b1 && b2) {
//			
//		}
//		
//		if (b1 & b2) {
//			
//		}
//		
//		if( b1 || b1) {
//			
//		}
//		
//		if (b1 | b2) {
//			
//		}
//		
//		String s = (a > b)?"a lon hon b": "a khong lon hon b";
//		
//		if( a == 5) {
//			
//		}
		
		 a = 20;
		 b = 50;

		while (a <= b) {
			if (a % 3 == 0) {
				System.out.print(a + " ");
			}
			a++;
		}
		
		
		
	}
}
