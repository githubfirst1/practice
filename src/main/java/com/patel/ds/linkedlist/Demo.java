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

            System.out.println("Enter your choice(20 to exit): ");
            int choice = new Scanner(System.in).nextInt();

            if(choice == 20) break;
            switch (choice) {
                case 1: list.displayList(); break;
                case 2: System.out.println("Size: " + list.count());; break;
                case 3: data = new Scanner(System.in).nextInt();list.search(data);
                    System.out.println(list.search(data));break;
                case 4: data = new Scanner(System.in).nextInt();list.insertAtBegin(data);break;
                case 5: data = new Scanner(System.in).nextInt();list.insertAtEnd(data);break;
                default: break;
            }
        }

        //list.displayList();
    }
}
