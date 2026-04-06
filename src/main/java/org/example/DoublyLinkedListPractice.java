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

        public DoublyLinkedListPractice() {}

        public DoublyLinkedListPractice(int value) {
            Node newNode = new Node(value);
            head = newNode;
            tail = newNode;
        }

        void printForward(){
            Node temp=head;
            while (temp!=null){
                System.out.print(temp.value);
                if(temp.next!=null){
                    System.out.print(" ⇄ ");
                }
                temp=temp.next;
            }
            System.out.println();
        }

        void append(int value) {
            Node newNode = new Node(value);
            if(head==null){
                head=newNode;
                tail=newNode;
                return;
            }
            tail.next=newNode;
            newNode.prev=tail;
            tail=newNode;
        }

        void prepend(int value) {
            Node newNode = new Node(value);
            if(head==null){
                head=newNode;
                tail=newNode;
                return;
            }
            head.prev=newNode;
            newNode.next=head;
            head=newNode;
        }

        void removeFirst() {
            if(head==null){
                return;
            }
            if(head==tail){
                head=null;
                tail=null;
                return;
            }
            head=head.next;
            head.prev=null;
            }

        void removeLast() {
            if(tail==null){
                return;
            }
            if(tail==head){
                tail=null;
                head=null;
                return;
            }
            tail=tail.prev;
            tail.next=null;
        }

        void removeAt(int index){

                if(head==null){
                    return;
                }

                if(index<0){
                    return;
                }
                Node current=head;
                int pos=0;
                while (current!=null && pos < index){
                    current=current.next;
                    pos++;
                }
                if(current==null){
                    return;
                }
                if(current==head){
                    removeFirst();
                    return;
                }
                if(current==tail){
                    removeLast();
                    return;
                }
                current.prev.next = current.next;
                current.next.prev = current.prev;
            }
    }



