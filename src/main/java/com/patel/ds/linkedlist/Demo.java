package com.patel.ds.linkedlist;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        list.createList();
        int data;
        while (true) {
            System.out.println("1.Display List");
            System.out.println("2.Count the number of nodes");
            System.out.println("3.Search for an element");
            System.out.println("4.Insert at the beginging");
            System.out.println("5.Insert at the end");
            System.out.println("6.Reference at the end");
            System.out.println("7.Reference to predecessor Node");
            System.out.println("8.Reference to ToAnElement");
            System.out.println("9.Reference to PredecessorElement");
            System.out.println("10.Reference to PartulularPosition");
            System.out.println("11.Delete at the begining");
            System.out.println("12.Delete at the end");
            System.out.println("13.Delete after");
            System.out.println("14.Reverse a linked list");
            System.out.println("15.Find max");

            System.out.println("Enter your choice(20 to exit): ");
            int choice = new Scanner(System.in).nextInt();

            if(choice == 20) break;
            switch (choice) {
                case 1: list.displayList(); break;
                case 2: System.out.println("Size: " + list.count()); break;
                case 3: data = new Scanner(System.in).nextInt();list.search(data);
                    System.out.println(list.search(data));break;
                case 4: data = new Scanner(System.in).nextInt();list.insertAtBegin(data);break;
                case 5: data = new Scanner(System.in).nextInt();list.insertAtEnd(data);break;
                case 6: if(list.referenceToLastNode() == null) {
                	System.out.println("Not enough elements, Node size: " + list.count());
                		} else {
                			System.out.println("Got the last node having element: " + list.referenceToLastNode().data);
                		}
        		break;
                case 7: if(list.referenceTo2ndLastNode() == null) {
        			System.out.println("Not enough elements, Node size: " + list.count());
        		} else {
        			System.out.println("Got the 2nd last node having element: " + list.referenceTo2ndLastNode().data);
        		}
            	break;
                case 8: data = new Scanner(System.in).nextInt();
                		Node temp = list.referenceToAnElement(data);
                		if(temp == null) {
                			System.out.println("Not enough elements, Node size: " + list.count());
                		} else {
                			System.out.println("Got the  element: " + temp.data);
                		}break;
                case 9: data = new Scanner(System.in).nextInt();
                		temp = list.referenceToPredecessorElement(data);
		                if(temp == null) {
		                	System.out.println("Not enough elements, Node size: " + list.count());
                		} else {
                			System.out.println("Got the predecessor element: " + temp.data);
                		}
		                break;
                case 10:data = new Scanner(System.in).nextInt();
                		temp = list.referenceAtPartulularPosition(data);
                		if( temp == null) {
                			System.out.println("Not enough elements, Node size: " + list.count());
                		} else {
                			System.out.println("Got the particular position element: " + temp.data);
                		}break;
                case 11: list.deleteAtBegin();break;
                case 12: list.deleteAtEnd();break;
                case 13: data = new Scanner(System.in).nextInt();list.deleteAfter(data);break;
                case 14: list.reverseRecursive();break;
                case 15:list.findMax();break;
                default: break;
                
            }
        }

        //list.displayList();
    }
}
