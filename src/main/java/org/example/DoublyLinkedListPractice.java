package org.example;

public class DoublyLinkedListPractice {

    int value;
    Node head;
    Node tail;
        class Node {
            int value;
            Node next;
            Node prev;
            public Node(int value) {
                this.value = value;
            }
        }

        void printForward(){
            Node temp=head;
            while (temp!=null){
                System.out.println(temp.value);
                temp=temp.next;
            }
        }
    }



