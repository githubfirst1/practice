package com.patel.ds.linkedlist;

import java.util.Scanner;

public class SingleLinkedList {
	private Node start;

	public SingleLinkedList() {

	}


	public void displayList() {
		if(start == null) {
			System.out.println("List is empty");
		}
		Node p;
		p = start;
		System.out.print("List is :  ");
		while (p != null) {
			System.out.print(p.data + " , ");
			p = p.link;
		}
		System.out.println();
	}

	public Node referenceToLastNode() {
		if(start == null) {
			System.out.println("List is empty");
			return null;
		}
		Node p;
		p = start;
		while (p.link != null) {
			p = p.link;
		}
		return p;
	}

	public Node referenceToAnElement(int data) {
		if(start == null) {
			System.out.println("List is empty");
			return null;
		}
		Node p;
		p = start;
		while (p.data != data) {
			p = p.link;
		}
		return p;
	}

	public Node referenceToPredecessorElement(int data) {
		if(start == null) {
			System.out.println("List is empty");
			return null;
		}
		Node p;
		p = start;
		while (p.link.data != data) {
			p = p.link;
		}
		return p;
	}

	public Node referenceAtPartulularPosition(int position) {
		if(start == null) {
			System.out.println("List is empty");
			return null;
		}
		Node p;
		p = start;
		for(int i = 1; i < position && p.link != null; i++) {
			p = p.link;
		}
		return p;
	}

	public Node referenceTo2ndLastNode() {
		Node p;
		p = start;
		if(p == null || p.link == null) {
			System.out.println("List is empty or there is only one element ");
			return null;
		}
		while (p.link.link != null) {
			p = p.link;
		}
		return p;
	}

	public void insertAtBegin(int data) {
		Node temp = new Node(data);
		temp.link = start;
		start = temp;
	}

	public void deleteAtBegin() {
		if(start != null) {
			start = start.link;
		}
	}

	public void deleteAtEnd() {
		Node p = start;
		while(p.link.link != null) {
			p = p.link;
		}
		p.link = null;
	}

	public void deleteAfter(int data) {
		Node p = referenceToPredecessorElement(data);
		p.link = p.link.link;

	}

	public Node reverse() {
		Node prev = null,next,current;
		current = start;

		while(current != null) {
			next = current.link;
			current.link = prev;
			prev = current;
			current = next;
		}
		start = prev;
		return start;
	}
	public void reverseRecursive() {start = reverseRecursive(start);}
	public Node reverseRecursive(Node head) {
		if (head == null || head.link == null) {
	        return head;
	    }

	    Node newHead = reverseRecursive(head.link); // reverse all but first
	    head.link.link = head; // make original second point at first
	    head.link = null; // make original first point at nothing

	    return newHead;
	}
	
	public void findMax() {
		 findMax(start);
		 findSecondMax(start);
		 findThirdMax(start);
	}

	private void findMax(Node start) {
		int max = 0;
		Node current = start;
		while(current != null) {
			max = current.data;
			if(current.link != null && current.link.data > max) {
				max = current.link.data;
			}
			current = current.link;
		}
		System.out.println(max);
	}
	
	private void findSecondMax(Node start) {
		int max1 = 0;
		int max2 = 0;
		Node current = start;
		while(current != null) {
			max1 = current.data;
			if(current.link != null && current.link.data > max1) {
				max2 = max1;
				max1 = current.link.data;
			} else if(current.link != null && current.link.data > max2) {
				max2 = current.link.data;
			}
			current = current.link;
		}
		System.out.println(max2);
	}
	
	private void findThirdMax(Node start) {
		int max1 = 0;
		int max2 = 0;
		int max3 = 0;
		Node current = start;
		while(current != null) {
			max1 = current.data;
			if(current.link != null && current.link.data > max1) {
				max3 = max2;
				max2 = max1;
				max1 = current.link.data;
			} else if(current.link != null && current.link.data > max2) {
				max3 = max2;
				max2 = current.link.data;
			} else if(current.link != null && current.link.data > max2) {
				max3 = current.link.data;
			}
			current = current.link;
		}
		System.out.println(max3);
	}



	public void insertAtEnd(int data) {
		Node p = start;
		Node temp = new Node(data);
		if(start == null) {
			start = temp;
			return;
		}
		while (p.link != null) {
			//while (p != null) {
			p = p.link;
		}
		p.link = temp;
	}

	public int count() {
		int count = 0;
		Node p = start;
		while (p != null) {
			count++;
			p = p.link;
		}
		return count;
	}

	public boolean search(int data) {
		Node p = start;
		while (p != null) {
			if(p.data == data) {
				return true;
			}
			p = p.link;
		}
		return false;
	}

	public void createList() {
		int i, n, data;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter number of nodes: ");
		n = scanner.nextInt();
		if (n == 0) {
			return;
		}
		System.out.println();
		for (i = 0; i < n; i++) {
			System.out.print("Enter element to be inserted: ");
			data = scanner.nextInt();
			insertAtEnd(data);
		}
		System.out.println();

	}
}
