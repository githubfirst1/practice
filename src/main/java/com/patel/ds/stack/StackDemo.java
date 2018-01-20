package com.patel.ds.stack;

import java.util.Stack;

public class StackDemo {
	public static void main(String[] args) {
		String input = new String("[[[]]{}()]");
		System.out.println(validate(input.toCharArray()));;
	}
	
	/**
	 * [] {}
	 * ]
	 * @param input
	 * @return bolean
	 */
	public static boolean validate(char input[]) {
		
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0; i < input.length; i++) {
			if(input[i] == '{' || input[i] == '[' || input[i] == '(') {
				stack.push(input[i]);
			}
			char temp;
			if(stack.isEmpty()) {
				return false;
			} else {
				temp = stack.peek();
			}
			if((input[i] == '}' && temp == '{') || (input[i] == ']' && temp == '[') || (input[i] == ')' && temp == '(')) {
				stack.pop();
			}
		}
		
		return stack.isEmpty();
	}
}
