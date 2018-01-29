package com.patel.ds.queue;

public class QueueA {
	private int queueArray[];
	private int front;
	private int rear;
	
	public QueueA() {
		queueArray = new int[10];
		front = -1;
		rear = -1;
	}
	
	public QueueA(int maxSize) {
		queueArray = new int[maxSize];
		front = -1;
		rear = -1;
	}
	
	public boolean isEmpty() {
		return (front == -1 || front == rear + 1);
	}
	
	public boolean isFull() {
		return (rear == queueArray.length - 1);
	}
	
	public int size() {
		if(isEmpty()) return 0;
		return rear-front+1;
	}
	
	public void insert(int input) {
		if(isFull()) {
			System.out.println("Overflow");
			return;
		}
		if(front == -1) front = 0;
		rear = rear + 1;
		queueArray[rear] = input;
	}
	
	public int delete() {
		if(isEmpty()) {
			System.out.println("Underflow");
			return -1;
		}
		int output = queueArray[front];
		front = front + 1;
		return output;
	}
	
	public int peek() {
		if(isEmpty()) {
			System.out.println("Underflow");
			return -1;
		}
		return queueArray[front];
	}
	
	public void display() {
		if(isEmpty()) {
			System.out.println("Queue is Empty");
		}
		for(int i = 0; i <= rear; i++) {
			System.out.print(queueArray[i] + ", ");
		}
	}
}
