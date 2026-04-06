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
        DoublyLinkedListPractice myPractice = new DoublyLinkedListPractice(10);
        myPractice.append(20);
        myPractice.append(30);
        myPractice.prepend(40);
        myPractice.append(50);
        myPractice.prepend(70);
        myPractice.removeFirst();
        myPractice.removeLast();
        myPractice.printForward();
        myPractice.removeAt(0);
        myPractice.printForward();
    }
}