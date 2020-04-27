package com.data.structures.stack;

import java.util.ArrayList;
import java.util.List;

public class StackList<X> implements Stack<X>{

    private List<X> data;

    public StackList(){
        this.data = new ArrayList<>();
    }
    public StackList(int size){
        data = new ArrayList<>(size);
    }

    public void push(X newItem){
        data.add( newItem );
    }

    public X pop(){

        if (size()==0){
            throw new IllegalStateException("No more item in the stack");
        }
        X item = data.get( size()-1);
        data.remove(item);
        return item;
    }

    public boolean contains(X item){

        for (int i=0; i<size(); i++){
            if (data.get(i).equals(item))
                return true;
        }
        return false;
    }

    public X access(X item){

        while (size()>0){
            X aux = pop();
            if (aux.equals(item))
                return aux;
        }
        throw new IllegalStateException("could not find the item in the stack");
    }

    public int size(){
        return data.size();
    }
}
