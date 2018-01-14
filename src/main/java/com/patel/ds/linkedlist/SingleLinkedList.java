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

    public void insertAtBegin(int data) {
        Node temp = new Node(data);
        temp.link = start;
        start = temp;
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
