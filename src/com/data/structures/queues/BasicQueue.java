package com.data.structures.queues;

public class BasicQueue<X> implements Queue<X>{

    private X data[];
    private int front;
    private int end;

    public BasicQueue(int size){
        data = (X[]) new Object[size];
        front = -1;
        end = -1;
    }

    public BasicQueue(){
        this(1000);
    }

    public int size(){
        if (front==-1 && end==-1)
            return 0;
        else
            return end - front + 1;
    }

    public void enQueue(X item){

        if( ( (end+1) % data.length) == front ) {
            throw new IllegalStateException("The queue is full!");
        }if (size()== 0){
            data[++end] = item;
            front = 0;
        } else {
            data[++end] = item;
        }
    }
    public X deQueue(){

        X item = null;

        if (size() == 0) {
            throw new IllegalStateException("The queue is empty!");
        }else if (front == end){
           item = data[front];
           data[front] = null;
           front = -1;
           end = -1;
        } else {
            item = data[front];
            data[front] = null;
            front++;
        }
        return item;
    }

    public boolean contains(X item){

        if (size()==0)
            return false;

        for (int i = 0; i < end ; i++) {
            if (data[i].equals(item))
                return true;
        }
        return false;
    }

    public X access(int position){

        if (size() == 0 || position>size())
            throw new IllegalStateException("The item could not be accessed");

        int realIndex = 0;
        for (int i = front; i < end; i++) {
            if (position == realIndex)
                return data[i];
            realIndex++;
        }

        throw new IllegalStateException("The item could not be accessed at the position " + position);
    }


}
