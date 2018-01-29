package com.patel.ds.queue;

import java.util.Scanner;

public class QueueAClient {
	public static void main(String[] args) {
		int choice,x;
		
		QueueA queueA = new QueueA(8);
		
		while(true) {
			System.out.println("1. Insert element in the queue");
			System.out.println("2. Delete a element from queue");
			System.out.println("3. Display front element in the queue");
			System.out.println("4.  Display all element in the queue");
			System.out.println("5.  Display size in the queue");
			System.out.println("6.  Quit");
			
			System.out.println("Enter your choice");
			choice = new Scanner(System.in).nextInt();
			if(choice == 6) break;
			
			switch(choice) {
			case 1: 
				System.out.println("Inser element to be inserted");
				queueA.insert(new Scanner(System.in).nextInt());
				break;
			case 2: 
				int element = queueA.delete();
				System.out.println("Deleted element from queue: " + element);
				break;
			case 3: 
				System.out.println("Front element in the queue: " + queueA.peek());
				break;
			case 4: 
				queueA.display();
				break;
			case 5:
				System.out.println("Size of the element in the queue: " + queueA.size());
				break;
			default: 
				System.out.println("Wrong choice");
				break;
			}
		}
	}
}
