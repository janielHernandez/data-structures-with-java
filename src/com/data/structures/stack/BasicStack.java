package com.data.structures.stack;

public class BasicStack<X> implements Stack<X>{

    private X[] data;
    private int stackPointer;

    public BasicStack(){
        data = (X[]) new Object[1000];
        stackPointer = 0;
    }

    public void push(X newItem){
        data[stackPointer++] = newItem;
    }

    public X pop(){

        if (stackPointer==0){
            throw new IllegalStateException("No more item in the stack");
        }
        return data[--stackPointer];
    }

    public boolean contains(X item){

        for (int i=0; i<stackPointer; i++){
            if (data[i].equals(item))
                return true;
        }
        return false;
    }

    public X access(X item){

        while (stackPointer>0){
            X aux = pop();
            if (aux.equals(item))
                return aux;
        }
        throw new IllegalStateException("could not find the item in the stack");
    }

    public int size(){
        return stackPointer;
    }
}
