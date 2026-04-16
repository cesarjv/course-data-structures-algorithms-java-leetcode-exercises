package org.example;

import java.util.ArrayList;

public class Stack<T> {

    private ArrayList<T> stackList = new ArrayList<>();

    public ArrayList<T> getStackList() {
        return stackList;
    }

    public boolean isEmpty() {
        return stackList.isEmpty();
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        } else {
            return stackList.get(stackList.size() - 1);
        }
    }

    public int size() {
        return stackList.size();
    }

    public void push(T value){
        if (value == null) {
            throw new IllegalArgumentException("Null values not allowed");
        }
        stackList.add(value);
    }

    public T pop(){
        if (stackList.isEmpty()){
            return null;
        }
        return stackList.remove(size()-1);
    }

}
