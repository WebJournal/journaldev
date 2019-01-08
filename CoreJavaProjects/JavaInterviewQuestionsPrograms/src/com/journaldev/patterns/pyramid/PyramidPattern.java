package com.journaldev.patterns.pyramid;

import java.util.Scanner;
/**
 * Pyramid Pattern Programs in Java
 * NOTE: Do Not Format, otherwise pattern in comments will be gone
 * @author pankaj
 *
 */
public class PyramidPattern {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the rows to print:");
		int rows = scanner.nextInt();
		// System.out.println("Rows = "+rows);
		scanner.close();

		System.out.println("Printing Pattern 1\n");
		printPattern1(rows);
		System.out.println("Printing Pattern 2\n");
		printPattern2(rows);
		System.out.println("Printing Pattern 3\n");
		printPattern3(rows);		
		System.out.println("Printing Pattern 4\n");
		printPattern4(rows);
		System.out.println("Printing Pattern 5\n");
		printPattern5(rows);
		System.out.println("Printing Inverted Pyramid Pattern 6\n");
		printPattern6(rows);
		System.out.println("Printing Inverted Pyramid Pattern 7\n");
		printPattern7(rows);

	}

	/**
	 * 
	 * @param rows
	 * Program to print below pyramid structure
	    1         
       2 2        
      3 3 3       
     4 4 4 4      
    5 5 5 5 5     
   6 6 6 6 6 6    
  7 7 7 7 7 7 7   
 8 8 8 8 8 8 8 8  
9 9 9 9 9 9 9 9 9 
	 */
	private static void printPattern1(int rows) {
		// for loop for the rows
		for (int i = 1; i <= rows; i++) {
			// white spaces in the front of the numbers
			int numberOfWhiteSpaces = rows - i;

			//print leading white spaces
			printString(" ", numberOfWhiteSpaces);

			//print numbers
			printString(i + " ", i);

			//move to next line
			System.out.println("");
		}
	}

	//utility function to print string given times
	private static void printString(String s, int times) {
		for (int j = 0; j < times; j++) {
			System.out.print(s);
		}
	}
	
	/**
	 * 
	 * Program to print below pyramid structure
	 *  1         
       1 2        
      1 2 3       
     1 2 3 4      
    1 2 3 4 5     
   1 2 3 4 5 6    
  1 2 3 4 5 6 7   
 1 2 3 4 5 6 7 8  
1 2 3 4 5 6 7 8 9 
	 */
	private static void printPattern2(int rows) {
		// for loop for the rows
		for (int i = 1; i <= rows; i++) {
			// white spaces in the front of the numbers
			int numberOfWhiteSpaces = rows - i;

			//print leading white spaces
			printString(" ", numberOfWhiteSpaces);

			//print numbers
			for(int x = 1; x<=i; x++) {
				System.out.print(x+" ");
			}

			//move to next line
			System.out.println("");
		}
	}
	
	
	/**
	 * Program to print following pyramid structure
	    *         
       * *        
      * * *       
     * * * *      
    * * * * *     
   * * * * * *    
  * * * * * * *   
 * * * * * * * *  
* * * * * * * * * 
	 */
	private static void printPattern3(int rows) {
		// for loop for the rows
		for (int i = 1; i <= rows; i++) {
			// white spaces in the front of the numbers
			int numberOfWhiteSpaces = rows - i;

			//print leading white spaces
			printString(" ", numberOfWhiteSpaces);

			//print character
			printString("* ", i);

			//move to next line
			System.out.println("");
		}
	}

	/**
	 * 
	 *          1 
              1 2 1 
            1 2 3 2 1 
          1 2 3 4 3 2 1 
        1 2 3 4 5 4 3 2 1 
      1 2 3 4 5 6 5 4 3 2 1 
    1 2 3 4 5 6 7 6 5 4 3 2 1 
  1 2 3 4 5 6 7 8 7 6 5 4 3 2 1 
1 2 3 4 5 6 7 8 9 8 7 6 5 4 3 2 1 
	 */
	private static void printPattern4(int rows) {
		// for loop for the rows
		for (int i = 1; i <= rows; i++) {
			// white spaces in the front of the numbers
			int numberOfWhiteSpaces = (rows-i)*2;

			//print leading white spaces
			printString(" ", numberOfWhiteSpaces);

			//print numbers
			for(int x=1; x<=i; x++) {
				System.out.print(x+" ");
			}
			for(int j=i-1; j>0; j--) {
				System.out.print(j+" ");
			}

			//move to next line
			System.out.println("");
		}
	}
	
	/**
	 * 
	 *            9 
                8 9 8 
              7 8 9 8 7 
            6 7 8 9 8 7 6 
          5 6 7 8 9 8 7 6 5 
        4 5 6 7 8 9 8 7 6 5 4 
      3 4 5 6 7 8 9 8 7 6 5 4 3 
    2 3 4 5 6 7 8 9 8 7 6 5 4 3 2 
  1 2 3 4 5 6 7 8 9 8 7 6 5 4 3 2 1 
	 */
	private static void printPattern5(int rows) {
		// for loop for the rows
		for (int i = rows; i >= 1; i--) {
			// white spaces in the front of the numbers
			int numberOfWhiteSpaces = i*2;

			//print leading white spaces
			printString(" ", numberOfWhiteSpaces);

			//print numbers
			for(int x=i; x<=rows; x++) {
				System.out.print(x+" ");
			}
			for(int j=rows-1; j>=i; j--) {
				System.out.print(j+" ");
			}

			//move to next line
			System.out.println("");
		}
	}
	
/**
 * 
* * * * * * * * * 
 * * * * * * * * 
  * * * * * * * 
   * * * * * * 
    * * * * * 
     * * * * 
      * * * 
       * * 
        * 
 */
	private static void printPattern6(int rows) {
		// for loop for the rows
		for (int i = rows; i >= 1; i--) {
			// white spaces in the front of the numbers
			int numberOfWhiteSpaces = rows - i;

			//print leading white spaces
			printString(" ", numberOfWhiteSpaces);

			//print character
			printString("* ", i);

			//move to next line
			System.out.println("");
		}
	}
	
	/**
	 * 
9 9 9 9 9 9 9 9 9 
 8 8 8 8 8 8 8 8 
  7 7 7 7 7 7 7 
   6 6 6 6 6 6 
    5 5 5 5 5 
     4 4 4 4 
      3 3 3 
       2 2 
        1 
	 */
	private static void printPattern7(int rows) {
		// for loop for the rows
		for (int i = rows; i >= 1; i--) {
			// white spaces in the front of the numbers
			int numberOfWhiteSpaces = rows - i;

			//print leading white spaces
			printString(" ", numberOfWhiteSpaces);

			//print character
			printString(i+" ", i);

			//move to next line
			System.out.println("");
		}
	}
}
