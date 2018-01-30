package com.patel.ds.stack;

import java.util.Stack;

/**
 * 
 * http://people.cs.ksu.edu/~schmidt/300s05/Lectures/Week3.html
 *
 */

public class EvaluatePostFix {
	/*
	  	Example: Arithmetic expression evaluation
		We begin with a famous example that uses a stack to remember partially completed computational tasks: Evaluating an arithmetic expression written in 
		postfix notation (``Lukasiewicz notation'').
		
		Postfix notation is an parenthesis-free way of writing arithmetic expressions, 
		where one places the operator symbol after the operator's two operands. For example, the addition of 3 to 2 is written 3 2 +, 
		and the multiplication of the result by 4 is written 3 2 + 4 *. Remarkably, parentheses are never needed. An example like
		
		((3 + 2) * 4) / (5 - 1)
		is written
		3 2 + 4 * 5 1 - /
		To see why parentheses are unnecessary, let's manually compute the expression:
		3 2 + 4 * 5 1 - /
		=>   5 4 * 5 1 - /
		=>  20 5 1 - /
		=>  20 4 /
		=> 5
		We see that an operator evaluates with the two operands that immediately precede it. This explains why the division operator is written last 
		in the original expression, because the division is performed only after all the other subexpressions are evaluated.
		Postfix arithmetic is more than an interesting oddity --- it is the standard format for writing arithmetic expressions 
		that must be executed by a CPU. Recall that the CPU's arithmetic-logic unit works with the CPU's registers to do arithmetic. 
		A CPU cannot compute the result of the expression, ((3 + 2) * 4) / (5 - 1), but it can compute the result of 3 2 + 4 * 5 1 - /, 
		because the operands and operators are now arranged in the correct order for loading numbers into registers and doing the operations. 
		Here is an assembly code sequence that tells the CPU how to compute the postfix expression:
		
		loadconst R1 3   // load Register 1 with constant 3
		loadconst R2 2   // load Register 2 with constant 2
		add R2 R1        // add Register 1 to Register 2
		loadconst R1 4   // etc.
		multiply  R2 R1
		loadconst R1 5
		loadconst R3 1
		subtract R1 R3
		divide R2 R1
		The register names, R1, R2, R3, are a bit distracting --- notice the pattern hidden in the instructions (erase the register names):
		loadconst 3
		loadconst 2
		add
		loadconst 4
		multiply
		loadconst 5
		loadconst 1
		subtract
		divide
		It is exactly the postfix expression! Indeed, the simplified version of the assembly code is called stack code or byte code, 
		and it is in fact the format of code embedded in the .class files constructed by the Java compiler.
		The Java compiler translates programs into posfix notation
		Because postfix format is ideal for computation with a CPU, 
		the Java compiler not only checks the grammar of your Java program, it also translates the program into postfix format --- even the assignments, 
		conditionals, and loops are reformatted into postfix format. If you write a program like this:
		
		...
		x = x + 1;
		if ( x > 2 ) 
		   { y = 2 * ( x - 3 ); }
		...
		the Java compiler produces the postfix-reformatted version:
		...
		x 1 + =x ; 
		x 2 > if
		    2 x 3 - * =y ;
		...
		and then writes the byte code (stack code) for the postfix version into the program's .class file:
		...
		load x
		loadconst 1
		add
		storeinto x
		load x
		loadconst 2
		greaterthan
		test_and_jump_if_false_to LabelA
		loadconst 2
		load x
		loadconst 3
		subtract
		multiply
		storeinto y
		LabelA: ...
		The example leaves us with two fundamental questions:
		
		How does the Java Virtual Machine execute the byte code?
		How does the Java compiler convert a Java program into postfix format (byte code)?
		Both questions are answered with the assistance of the stack data structure.
		The Java Virtual Machine uses a stack
		A stack is the ideal data structure for evaluating an arithmetic expression written in postfix notation.
		Recall again that the postfix version of ((3 + 2) * 4) / (5 - 1) is
		
		3 2 + 4 * 5 1 - /
		Figure 2 illustrates how we might use a stack to compute the result of this expression --- the stack holds the results of subexpressions that 
		are awaiting further computation.
		In the Figure below, the stack is drawn as if it were a stack of dinner plates---it grows vertically. 
		The arithmetic expression shrinks horizontally as it is read and computed.
		
		FIGURE 2: postfix expression evaluation with a stack data structure========
		
		 Stack    Expression
		
		|   |
		 ---        3 2 + 4 * 5 1 - /
		(empty)
		
		| 3 |       2 + 4 * 5 1 - /
		 ---
		
		| 2 |      
		| 3 |       + 4 * 5 1 - /
		 ---
		
		| 5 |       4 * 5 1 - /
		 ---
		
		| 4 |
		| 5 |       * 5 1 - /
		 ---
		
		| 20|       5 1 - /
		 ---
		
		| 5 |
		| 20|       1 - /
		 ---
		
		| 1 |
		| 5 |
		| 20|       - /
		 ---
		
		| 4 |
		| 20|       /
		 ---
		
		| 5 |      (finished)
		 ---
	 */
	public static int evaluatePostFix(String input) {
		
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i = 0; i < input.length(); i++) {
			
			char c = input.charAt(i);
			if(Character.isDigit(c)) {
				
				stack.push(c - '0');
				
			} else {
				
				int operand1 = stack.pop();
				int operand2 = stack.pop();
				
				switch(c) {
				case '+': 
					stack.push(operand2 + operand1);
					break;
					
				case '-': 
					stack.push(operand2 - operand1);
					break;
					
				case '*': 
					stack.push(operand2 * operand1);
					break;
					
				case '/': 
					stack.push(operand2 / operand1);
					break;
				}
			}
		}
		
		return stack.pop();
	}
	
	public static void main(String[] args) {
		System.out.println(evaluatePostFix("32+4*51-/"));
	}
}
