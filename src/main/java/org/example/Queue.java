package org.example;


public class Queue {

    Stack<Integer> stack1=new Stack<>();
    Stack<Integer> stack2= new Stack<>();

    /* “Para implementar enqueue usando dos stacks, muevo temporalmente todos los elementos del stack principal
        a un stack auxiliar, inserto el nuevo elemento y luego restauro los elementos.
        De esta forma mantengo el orden FIFO en el stack principal, permitiendo que dequeue sea una operación O(1).”
     */
    public void enqueue(int value){
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        stack1.push(value);
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
    }

    /* “Como mantengo el orden FIFO directamente en el stack principal durante enqueue,
        el método dequeue se reduce a un pop() del stack principal, logrando una operación O(1).”
     */

    public Integer dequeue() {
        if(stack1.isEmpty()){
            return null;
        }
        return stack1.pop();
    }
}
