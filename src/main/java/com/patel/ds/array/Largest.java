package com.patel.ds.array;

public class Largest {
	public static void main(String[] args) {
		int input[] = {2,45,67,87,44,65,93,91};
		System.out.println(max(input));
		System.out.println(secondMax(input));
		System.out.println(thirdMax(input));
	}
	
	private static int max(int[] input) {
		int max1 = input[0];
		for(int i = 0; i < input.length; i++) {
			if(input[i] > max1) {
				max1 = input[i];
			}
		}
		return max1;
	}
	
	private static int secondMax(int[] input) {
		int max1 = input[0];
		int max2 = input[0];
		for(int i = 0; i < input.length; i++) {
			if(input[i] > max1) {
				max2 = max1;
				max1 = input[i];
			} else if(input[i] > max2) { // this else block is required if after max element there exist 2nd max clement
				max2 = input[i];
			}
		}
		return max2;
	}
	
	private static int thirdMax(int[] input) {
		int max1 = input[0];
		int max2 = input[0];
		int max3 = input[0];
		for(int i = 0; i < input.length; i++) {
			if(input[i] > max1) {
				max3 = max2;
				max2 = max1;
				max1 = input[i];
			} else if(input[i] > max2) { 
				max3 = max2;
				max2 = input[i];
			} else if(input[i] > max3) {
				max3 = input[i];
			}
		}
		return max3;
	}
}
