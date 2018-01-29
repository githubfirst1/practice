package com.patel.ds.recur;

/**
 * 
 * @author Bhupati Patel
 * Recursion Demo
 *
 */

public class Demo {
	public static void main(String[] args) {
		
		
		
//		char temp[] = "ab".toCharArray();
//		swap(temp,0,1);
//		permutation("abc");
		//permutation("","abcd");
		subSets("", "abc");
		//permute1();
		//System.out.println(reverseString("abc"));
		//System.out.println("********");
	}
	
	/*
	 * Tail recursive, Print 1 to 10
	 */
	static void print(int n) {
		if(n == 0) return;
		System.out.print(n + " ");
		print(n-1);
	}
	
	/*
	 * Not a Tail recursive, Print 1 to 10
	 */
	static void print2(int n) {
		if(n == 0) return;
		print2(n-1);
		System.out.print(n + " ");
	}
	
	/*
	 * Factorial of a number, not a tail recursive as the return statement contains an expression 
	 */
	static int factorial(int n) {
		if(n==0) return 1;
		return n * factorial(n-1);
	}
	
	/*
	 *Sum of digits of a number, e.g input 45981, output: 27
	 *not a tail recursive as the return statement contains an expression 
	 */
	
	static int sumOfDigits(int input) {
		if(input == 0) return input;
		return sumOfDigits(input/10) + input%10;
	}
	
	static String reverseString(String input) {
		if(input.isEmpty() || input.length() == 1) return input;
		String rest = reverseString(input.substring(1));
		System.out.println("rest: " + rest + ", input: " + input);
		String reverse = rest + input.charAt(0);
		System.out.println("reverse: " + reverse);
		return  reverse ;
	}
	
	/*
	 *power of a number, e.g input 6 to the power 3, output: 216
	 *not a tail recursive as the return statement contains an expression 
	 */
	static int powerOfANumber(int number, int power) {
		if(power == 0) return 1;
		return number * powerOfANumber(number, power-1);
		
	}
	/*
	 * Binary representation of a Decimal number. e.g. input 13, output:1101
	 */
	static void binary(int input) {
		if(input == 0) return;
		binary(input/2);
		System.out.print(input%2);
	}
	
	/*
	 * GCD of a two numbers, e.g. 45,36 output:9
	 * It is a tail recursive
	 */
	static int gcd(int m, int n) {
		if(n==0) return m;
		return gcd(n,m%n);
	}
	
	/**
	 * Towers of hanoi
	 * 
	 * if n = 1,
	 * Move disk 1 from source A to destination C.
	 * 
	 * if n = 2,
	 * Move disk 1 from source A to destination B,
	 * Move disk 2 from source A to destination C,
	 * Move disk 1 from source B to destination C.
	 */
	static void hanoi(int n, char source, char inter, char destination) {
		if(n == 1) System.out.println("Move disk " + n + " from source " + source + " to destination " + destination);
		else {
			hanoi(n-1,source,destination,inter); // tail recursive
			System.out.println("Move disk " + n + " from source " + source + " to destination " + destination);
			hanoi(n-1,inter,source,destination); // not a tail recursive
			
		}
		
	}
	
	
	static void permutation(String input){permutation(input.toCharArray(), 0, 3);}
	
	
	/**
	 * In the beginning A can be swap with itself A or B or C, leading to results ABC,BAC,CBA. 
	 * Now the first left character is fixed, for each of ABC,BAC,CBA, we can swap last two characters for each of generated strings
	 * At the end when there is only one character left there is nothing to swap.
	 * 
	 * 						ABC
	 *					  /  \  \
	 *			   		ABC   BAC CBA
	 *				  /\     /\      / \
	 *				ABC ACB BAC BCA CBA CAB
	 */
	public static void perm(char[] input, int start) {
		  if (start == input.length) {
		    //result.add((int[]) nums.clone());
			  System.out.println(input);
		    return;
		  }
		  for (int i = start; i < input.length; i++) {
		    swap(input, start, i);
		    perm(input, start + 1);
		    swap(input, start, i);
		  }
		}
	
		public static void swap(char[] input, int start, int end) {
		  char tmp = input[start];
		  input[start] = input[end];
		  input[end] = tmp;
		}
		
		/**
		 * In the beginning A can be swap with itself A or B or C, leading to results ABC,BAC,CBA. 
		 * Now the first left character is fixed, for each of ABC,BAC,CBA, we can swap last two characters for each of generated strings
		 * At the end when there is only one character left there is nothing to swap.
		 * 
		 * 						ABC
		 *					  /  \  \
		 *			   		ABC   BAC CBA
		 *				  /\     /\      / \
		 *				ABC ACB BAC BCA CBA CAB
		 */
		
		public static void permutation(char[] input, int start, int end) {
			if(start == end) {
				System.out.println(input);
			} 
			
			for(int i = start; i < end; i++) {
				swap(input, start, i);
				permutation(input, start+1, end);
				swap(input, start, i);
			}
		}
		
		
		/**
		 * In the beginning A can be swap with itself A or B or C, leading to results ABC,BAC,CBA. 
		 * Now the first left character is fixed, for each of ABC,BAC,CBA, we can swap last two characters for each of generated strings
		 * At the end when there is only one character left there is nothing to swap.
		 * 
		 * 						ABC
		 *					  /  \  \
		 *			   		ABC   BAC CBA
		 *				  /\     /\      / \
		 *				ABC ACB BAC BCA CBA CAB
		 */
		
		public static void permutation(String soFar, String remain){
			if(remain.isEmpty()) {
				System.out.println(soFar);
			} else {
				for(int i = 0; i < remain.length(); i++) {
					String remaining = remain.substring(0,i) + remain.substring(i+1);
					permutation(soFar + remain.charAt(i), remain.substring(0,i) + remain.substring(i+1));
				}
			}
			
		}
		
		public static void subSets(String soFar, String remain){
			if(remain.isEmpty()) {
				System.out.println(soFar);
			} else {
				subSets(soFar + remain.charAt(0), remain.substring(1));
				subSets(soFar, remain.substring(1));
			}
			
		}
		
		/**
		 * permutation using for loops
		 */
		public static void permute1() {
			String input = "ab";
			char input2[] = {'a','b','c'};
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
//					if(j == i) {
//						continue;
//					}
					for(int k = 0; k < 3; k++) {
//						if(k == j || k == i) {
//							continue;
//						}
//						System.out.print(input2[i]);
//						System.out.print(input2[j]);
//						System.out.print(input2[k]);
//						System.out.println();
						System.out.print(i);
						System.out.print(j);
						System.out.print(k);
						System.out.println();
					}
				}
			}
		}
		
		
	
}
