package org.example;

public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int length;

     class Node {
        int value;
        Node next;
        Node prev;

        Node (int value){
            this.value=value;
        }
    }

    public DoublyLinkedList(int value){
        Node newNode= new Node(value);
        head=newNode;
        tail=newNode;
        length=1;
    }

    public void getHead() {
        System.out.println("Head :" + head.value);
    }

    public void getTail() {
        System.out.println("Tail :" + tail.value);
    }

    public void getLength() {
        System.out.println("Length :" + length);
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
        System.out.println("\nDoubly Linked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void append(int value){
         Node newNode=new Node(value);
         if(length==0){
             head=newNode;
         }
         else {
             tail.next=newNode;
             newNode.prev=tail;
         }
        tail=newNode;
        length++;
    }

    public Node removeLast() {
        if(length==0) return null;
        Node temp=tail;
        if(length==1){
            head=null;
            tail=null;
        }
        else {
            tail=tail.prev;
            tail.next=null;
            temp.prev=null;
        }
        length--;
        return temp;
    }

    public void prepend(int value){
         Node newNode=new Node(value);
         if(length==0){
             head=newNode;
             tail=newNode;
         }

         else {
             newNode.next=head;
             head.prev=newNode;
             head=newNode;
         }
         length++;
    }

    public Node removeFirst() {
        if (length == 0) return null;
        Node temp = head;
        if (length == 1) {
            head = null;
            tail = null;
        }
        else {
        head = head.next;
        head.prev = null;
        temp.next = null;
        }
        length--;
        return temp;
    }

    public Node get(int index) {
        if(index < 0 || index >= length) return null;
        Node temp=head;
        if(index < length/2){
            for(int i=0; i < index; i++){
                    temp=temp.next;
            }
        }
        else {
            temp=tail;
            for (int i=length -1; i > index; i--) {
                temp=temp.prev;
            }
        }
        return temp;
    }

    public boolean isPalindrome() {

         Node forwards=head;
         Node backwards=tail;
         if(length==0 || length==1){
             return true;
         }
         while(forwards != backwards && forwards.prev != backwards){
             if(forwards.value != backwards.value){
                 return false;
             }
             forwards=forwards.next;
             backwards=backwards.prev;
         }
         return true;
    }

    public void reverse(){
        Node current=head;
        Node temp;
        Node last=null;
        Node oldHead = head;
            while(current!=null){
                temp=current.prev; /* temp=null,1 */
                current.prev=current.next; /* current.prev=2,3 */
                current.next=temp;/* current.next=null,1*/
                last=current;/* 1,2 */
                current=current.prev;/* current=2,3 */
            }
        head = last; /* 1,2*/
        tail = oldHead;
    }

    public void partitionList(int x){
        Node current=head;
        Node leftHead=null;
        Node leftTail=null;
        Node rightHead=null;
        Node rightTail=null;
        Node next=null;

        if(head==null) return;

        while (current!=null){
            next=current.next;
            current.next=null;
            current.prev=null;
            if(current.value < x){
                if(leftHead==null){
                    leftHead=current;
                    leftTail=current;
                }
                else {
                    leftTail.next=current;
                    current.prev=leftTail;
                    leftTail=current;
                }
            }
            else {
                if(rightHead==null){
                    rightHead=current;
                    rightTail=current;
                }
                else {
                    rightTail.next=current;
                    current.prev=rightTail;
                    rightTail=current;
                }
            }
            current=next;
        }

        if(leftHead!=null && rightHead !=null){
            leftTail.next=rightHead;
            rightHead.prev=leftTail;
            head=leftHead;
            tail=rightTail;
        }
        else if(leftHead==null){
            head=rightHead;
            tail=rightTail;
            rightHead.prev=null;
        }
        else if(rightHead==null){
            head=leftHead;
            tail=leftTail;
            leftHead.prev=null;
        }
     }

    public void reverseBetween(int startIndex, int endIndex) {

        Node tail=null;

        // ✅ Lista vacía o tramo de longitud 0
        if (head == null || startIndex == endIndex) return;

        // ✅ Soporte de rangos invertidos
        if (startIndex > endIndex) {
            int temp = startIndex;
            startIndex = endIndex;
            endIndex = temp;
        }

        // ✅ Convertir índices 0-based a 1-based
        startIndex++;
        endIndex++;

        // ✅ Contar longitud
        int length = 0;
        Node t = head;
        while (t != null) {
            length++;
            t = t.next;
        }

        // ✅ Indices fuera de rango
        if (startIndex > length) return;
        if (endIndex > length) endIndex = length;

        // ✅ Crear dummy para simplificar todo
        Node dummy = new Node(0);
        dummy.next = head;
        head.prev = dummy;

        // ✅ Mover prev al nodo previo al startIndex
        Node prev = dummy;
        for (int i = 1; i < startIndex; i++) {
            prev = prev.next;
        }

        // ✅ current es el primer nodo del tramo
        Node current = prev.next;

        // ✅ Reubicar nodos al inicio del tramo
        for (int i = 0; i < endIndex - startIndex; i++) {

            Node nodeToMove = current.next;

            // Quitar nodeToMove del tramo
            current.next = nodeToMove.next;
            if (nodeToMove.next != null)
                nodeToMove.next.prev = current;

            // Insertar nodeToMove al inicio del tramo
            nodeToMove.next = prev.next;
            prev.next.prev = nodeToMove;

            prev.next = nodeToMove;
            nodeToMove.prev = prev;
        }

        // ✅ Actualizar head real
        head = dummy.next;
        head.prev = null;

        // ✅ Actualizar tail real
        Node tailSearch = head;
        while (tailSearch.next != null)
            tailSearch = tailSearch.next;

        tail = tailSearch;
    }
}
