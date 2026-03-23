package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /* DoublyLinkedList myDLL=new DoublyLinkedList(7);
        myDLL.getHead();
        myDLL.getTail();
        myDLL.getLength(); */

        DoublyLinkedList myDLL= new DoublyLinkedList(1);
        myDLL.printList();
        myDLL.removeLast();
        myDLL.printList();
    }
}