package com.patel.ds.search;

public class Search {
	
	private static int LINEAR_INPUT_ARRAY[] = {1,2,3,4,5,6,7,8};
	private static int BINARY_INPUT_ARRAY[] = {1,2,3,4,5,6,7,8,67};
	
	
	public static void main(String[] args) {
		System.out.println(linearSearch(7));
		System.out.println(binarySearch2(2));
		System.out.println(binarySearchR(BINARY_INPUT_ARRAY,2,0,BINARY_INPUT_ARRAY.length-1));
	}
	
	private static boolean linearSearch(int input) {
		for(int i = 0; i < LINEAR_INPUT_ARRAY.length; i++) {
			if(LINEAR_INPUT_ARRAY[i] == input) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean binarySearch(int input) {
		int start = 0, end = BINARY_INPUT_ARRAY.length-1;
		while(start <= end) {
			int mid = (start+end)/2;
			if(BINARY_INPUT_ARRAY[mid] == input) {
				return true;
			} else if(BINARY_INPUT_ARRAY[mid] < input) {
				start = mid+1;
			} else {
				end = mid-1;
			}
		}
		
		return false;
	}
	
	private static boolean binarySearch2(int input) {
		int start = 0, end = BINARY_INPUT_ARRAY.length-1;
		while(start <= end) {
			int mid = (start+end)/2;
			if(BINARY_INPUT_ARRAY[mid] == input) {
				return true;
			} else if(input < BINARY_INPUT_ARRAY[mid]) {
				end = mid-1;
			} else {
				start = mid+1;
			}
		}
		
		return false;
	}
	
	private static boolean binarySearchR(int[] array, int input, int start, int end) {
		if(start > end) {
			return false;
		}
		int mid = (start+end)/2;
		if(array[mid] == input) {
			return true;
		} else if(array[mid] < input) {
			return binarySearchR(array,input, mid+1,end);
		} else {
			return binarySearchR(array,input, start,mid-1);
		}
	}
}
