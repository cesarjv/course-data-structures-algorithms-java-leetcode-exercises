package org.example;

import java.util.HashSet;
import java.util.Set;

public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    static class Node {
        int value;
        Node next;

        Node (int value){
            this.value=value;
        }
    }

    public LinkedList (int value){
        Node node=new Node(value);
        this.head=node;
        this.tail=node;
        length=1;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }


    public void append(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }


    /**
     * Retorna el nodo medio de la lista.
     * Si la longitud es par, retorna el segundo de los dos medios.
     * @return el nodo medio, o null si la lista está vacía
     */

    public Node findMiddleNode(){
        Node fast=head;
        Node slow=head;
        while (fast != null && fast.next != null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    /**
     * Detecta si la lista enlazada contiene un ciclo usando
     * el algoritmo de Floyd (Tortoise and Hare).
     *
     * @return true si existe un ciclo; false si no.
     */

    public boolean hasLoop() {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }


    /**
     * Retorna el k-ésimo nodo desde el final de la lista (1-indexado).
     * Si k es mayor que la longitud, retorna null.
     */

    public Node findKthFromEnd(int k) {
        Node slow=head;
        Node fast=head;
        for (int i=0; i < k; i++){
            if(fast == null) {
                return null;
            }
            fast=fast.next;
        }
        while(fast != null){
                slow=slow.next;
                fast=fast.next;
        }
        return slow;
    }

    public void removeDuplicates(){

        Set<Integer> seen=new HashSet<>();
        Node prev=null;
        Node curr=head;
         while (curr != null){
             if(seen.contains(curr.value)){
                 prev.next=curr.next;
             }
             else {
                 seen.add(curr.value);
                 prev=curr;
             }
             curr=curr.next;
         }
    }

    public int binaryToDecimal(){
        Node curr=head;
        int result=0;
        while (curr != null){
            result =(result*2) + curr.value;
            curr=curr.next;
        }
        return result;
    }

    public void swapPairs(){

        Node dummy=new Node(-1);
        dummy.next=head;
        Node prev=dummy;

        while (prev.next != null && prev.next.next != null){
            Node a = prev.next;        // 1er nodo del par
            Node b = a.next;           // 2do nodo del par
            Node nextPair = b.next;    //  siguiente inicio
            // 🔧 Reconexiones correctas:
            prev.next = b;             // prev -> b
            b.next = a;                // b -> a
            a.next = nextPair;         // a -> nextPair

            prev=a;
        }
        head=dummy.next;
    }
}