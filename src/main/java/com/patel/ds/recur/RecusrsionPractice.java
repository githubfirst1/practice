package com.patel.ds.recur;

public class RecusrsionPractice {
	public static void main(String[] args) {
		//print(3);
		//printR(3);
		int answer[] = {1,2,3};
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.println(answer[i]+","+answer[j]);
			}
		}
	}

	private static void printR(int i) {
		if(i==0) return;
		printR(i-1);
		System.out.println(i);
	}

	private static void print(int i) {
		print1(i-1);
		System.out.println(i);
	}

	private static void print1(int i) {
		print2(i-1);
		System.out.println(i);
	}

	private static void print2(int i) {
		print3(i-1);
		System.out.println(i);
	}

	private static void print3(int i) {
		if(i==0) return;
		print4(i-1);
		System.out.println(i);
	}

	private static void print4(int i) {
		
	}
}
