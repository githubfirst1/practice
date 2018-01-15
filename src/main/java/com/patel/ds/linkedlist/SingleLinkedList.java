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
    public void reverseRecursive() {reverseRecursive(start);}
    public Node reverseRecursive(Node start) {
    	if(start == null) return start;
    	
    	else {
    		Node prev=null,next,current;
    		current = reverseRecursive(start.link);
    		next = current.link;
        	current.link = prev;
        	prev = current;
        	current = next;
    		
    		return prev;
    	}
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
