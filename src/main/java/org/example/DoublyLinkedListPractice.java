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

        void moveToHead(int index){
            if(index < 0){
                return;
            }
            if (head==null){
                return;
            }
            Node current=head;
            int pos=0;
            while(current!=null && pos<index){
                current=current.next;
                pos++;
            }
            if (current==null){
                return;
            }
            if(current==head){
                return;
            }
            if(current==tail) {
                tail=current.prev;
                tail.next=null;
                head.prev=current;
                current.prev=null;
            }
            else {
                current.prev.next=current.next;
                current.next.prev=current.prev;
                current.prev = null;
                head.prev=current;
            }
            current.next=head;
            head=current;
        }

        void moveToTail(int index){
            if(index < 0){
                return;
            }
            if (head==null){
                return;
            }
            Node current=head;
            int pos=0;
            while(current!=null && pos<index){
                current=current.next;
                pos++;
            }

            if (current == null) {
                return;
            }
            if(current==tail){
                return;
            }

            if(current==head){
                head=current.next;
                head.prev=null;
                tail.next=current;
                current.next=null;
            }
            else {
                current.prev.next=current.next;
                current.next.prev=current.prev;
                current.next = null;
                tail.next=current;
            }
            current.prev=tail;
            tail=current;
        }


        void moveFromIndexToIndex(int from, int to) {

            // ===============================
            // 1. VALIDACIONES INICIALES
            // ===============================

            // Si alguno de los índices es negativo, no hacemos nada
            if (from < 0 || to < 0) {
                return;
            }

            // Si from y to son iguales, no hay nada que mover
            if (from == to) {
                return;
            }

            // ===============================
            // 2. BUSCAR EL NODO EN POSICIÓN 'from'
            // ===============================

            Node nodeFrom = head;
            int pos = 0;

            // Recorremos la lista hasta llegar a la posición 'from'
            while (nodeFrom != null && pos < from) {
                nodeFrom = nodeFrom.next;
                pos++;
            }

            // Si llegamos a null, el índice 'from' no existe
            if (nodeFrom == null) {
                return;
            }

            // ===============================
            // 3. EXTRAER nodeFrom DE LA LISTA
            // ===============================

            // Caso 1: nodeFrom es el head
            if (nodeFrom == head) {
                head = nodeFrom.next;

                // Si la lista no quedó vacía, actualizamos prev del nuevo head
                if (head != null) {
                    head.prev = null;
                }
            }
            // Caso 2: nodeFrom es el tail
            else if (nodeFrom == tail) {
                tail = nodeFrom.prev;

                // Cerramos la lista por detrás
                tail.next = null;
            }
            // Caso 3: nodeFrom está en el medio
            else {
                nodeFrom.prev.next = nodeFrom.next;
                nodeFrom.next.prev = nodeFrom.prev;
            }

            // Limpiamos los enlaces del nodo extraído
            nodeFrom.next = null;
            nodeFrom.prev = null;

            // ===============================
            // 4. SI LA LISTA QUEDÓ VACÍA
            // ===============================

            // Esto ocurre si la lista tenía un solo nodo
            if (head == null) {
                head = nodeFrom;
                tail = nodeFrom;
                return;
            }

            // ===============================
            // 5. BUSCAR LA POSICIÓN 'to'
            // ===============================

            Node nodeTo = head;
            pos = 0;

            // Recorremos hasta la posición 'to'
            while (nodeTo != null && pos < to) {
                nodeTo = nodeTo.next;
                pos++;
            }

            // ===============================
            // 6. INSERTAR nodeFrom EN LA POSICIÓN 'to'
            // ===============================

            // Caso A: insertar como nuevo head (to == 0)
            if (to == 0) {
                nodeFrom.next = head;
                head.prev = nodeFrom;
                head = nodeFrom;
                return;
            }

            // Caso B: insertar al final (end)
            // Esto pasa cuando nodeTo == null
            else if (nodeTo == null) {
                nodeFrom.prev = tail;
                tail.next = nodeFrom;
                tail = nodeFrom;
                return;
            }

            // Caso C: insertar en el medio, antes de nodeTo
            nodeFrom.next = nodeTo;
            nodeFrom.prev = nodeTo.prev;
            nodeTo.prev.next = nodeFrom;
            nodeTo.prev = nodeFrom;
        }

        public void reverse(){

            // ✅ Protección total contra lista vacía
            if (head == null || head.next == null) {
                return;
            }
            Node dummy=new Node(0);

            if(head==null) return;

            dummy.next=head;
            head.prev=dummy;
            dummy.prev=null;
            Node current=head;

            while(current.next != null){

                Node nodeToMove=current.next;
                Node nextOriginal=nodeToMove.next;

                // Desconectar nodeToMove
                current.next=nextOriginal;
                if(nextOriginal !=null){
                   nextOriginal.prev=current;
                }
                // Insertar nodeToMove después del dummy
                nodeToMove.prev=dummy;
                nodeToMove.next=dummy.next;
                dummy.next.prev=nodeToMove;
                dummy.next=nodeToMove;
            }

            // 🔴 CIERRE FINAL
            head = dummy.next;
            head.prev = null;
            tail = current;

        }

    public void swapPairs(){
            Node dummy= new Node(0);
            dummy.next=head;
            if(head != null){
                head.prev=dummy;
            }
            Node current=dummy;

            while(current.next !=null && current.next.next != null){
                    Node first=current.next;
                    Node second=current.next.next;
                    Node rest=second.next;
                  // Conectar current con second
                    current.next=second;
                    second.prev=current;
                  // Conectar second con first
                    second.next=first;
                    first.prev=second;
                  // Conectar first con el resto
                    first.next=rest;
                    if (rest != null) {
                      rest.prev = first;
                    }
                    current=first;
              }

            // actualizar head
            head = dummy.next;
            head.prev = null;
    }
}



