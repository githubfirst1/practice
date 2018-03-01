package com.patel.ds.stack.practice;

public class StackA {
	
	private int top = -1;
	private static int DEFAULTSIZE = 10;;
	private int stackArray[];
	
	public StackA() {
		stackArray = new int[10];
	}
	
	public StackA(int size) {
		stackArray = new int[size];
	}
	
	public boolean isEmpty() {
		return (top == -1);
	}
	
	public int size() {
		return top + 1;
	}
	
	public boolean isFull() {
		return (top == stackArray.length - 1);
	}
	
	public void push(int input) {
		if(isFull()) {
			System.out.println("Stack Overflow");
			return;
		}
		stackArray[++top] = input;
	}
	
	public int pop(int input) {
		if(isEmpty()) {
			System.out.println("Stack Underflow");
			return -1;
		}
		return stackArray[top--];
	}
	
	public int peek(int input) {
		if(isEmpty()) {
			System.out.println("Stack Underflow");
			return -1;
		}
		return stackArray[top];
	}
}
