package org.example;

import static org.example.StringUtils.reverseString;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /* DoublyLinkedList myDLL=new DoublyLinkedList(7);
        myDLL.getHead();
        myDLL.getTail();
        myDLL.getLength(); */

        /* DoublyLinkedList myDLL= new DoublyLinkedList(1);
        myDLL.printList();
        myDLL.removeLast();
        myDLL.printList();
        DoublyLinkedListPractice myPractice = new DoublyLinkedListPractice(10);
        myPractice.append(20);
        myPractice.append(30);
        myPractice.prepend(40);
        myPractice.append(50);
        myPractice.prepend(70);
        myPractice.removeFirst();
        myPractice.removeLast();
        /*myPractice.printForward();
        myPractice.removeAt(0);
        myPractice.printForward();
        myPractice.moveToHead(2);
        myPractice.printForward();
        myPractice.append(100);
        myPractice.append(40);
        myPractice.printForward();
        myPractice.moveFromIndexToIndex(1,4);
        myPractice.printForward();
        myPractice.reverse();
        myPractice.printForward();
        System.out.println(reverseString("hola")) */;
        HashTable myHashTable=new HashTable();
        myHashTable.set("nail",100);
        myHashTable.set("tile",120);
        myHashTable.set("lumber",58);
        myHashTable.set("bolts",200);
        myHashTable.set("screw",220);
        myHashTable.printTable();
        System.out.println(myHashTable.get("screw"));
    }
}