package com.data.structures.queues;

import java.util.ArrayList;
import java.util.List;

public class QueueList<X> implements Queue<X> {

    private List<X> data;

    public QueueList(int size){
        data = new ArrayList<>(size);
    }

    public QueueList(){
        data = new ArrayList<>();
    }

    public int size(){
        return data.size();
    }

    public void enQueue(X item){
        data.add(item);
    }
    public X deQueue(){

        if (size()==0)
            throw new IllegalStateException("The queue is empty");

        X item = data.get(0);
        data.remove( item );
        return item;
    }

    public boolean contains(X item){
       return data.contains(item);
    }

    public X access(int position){

        if (size() == 0 || position>size())
            throw new IllegalStateException("The item could not be accessed");

      return data.get(position);

    }


}
