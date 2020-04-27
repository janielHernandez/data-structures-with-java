package com.data.structures.lists;

public class BasicLinkedList<X> {

    private Node first;
    private Node last;
    private int nodeCount;

    public BasicLinkedList(){
        first = null;
        last = null;
        nodeCount = 0;
    }

    public int size(){
        return nodeCount;
    }

    public void add(X item){

        Node node = new Node(item);
        if (first==null){
            first = node;
        } else {
            last.setNext( node );
        }
        nodeCount++;
        last = node;
    }

    public X remove(){
        if (size()==0){
            throw new IllegalStateException("The list is empty");
        }else{
            X item = first.getItem();
            Node next= first.getNext();
            first = next;
            nodeCount--;
            return item;
        }
    }

    public void insert(X item, int position){

        if (position > size()){
            throw new IllegalStateException("Position grater that the size of the list ");
        }

        Node currentNode = first;
        for(int i=1; position>i && currentNode != null; i++)
            currentNode = currentNode.getNext();

        Node newNode = new Node(item);
        Node next = currentNode.getNext();
        currentNode.setNext( newNode );
        newNode.setNext( next );
        nodeCount++;
    }

    public X removeAt(int position){

        if (position > size()){
            throw new IllegalStateException("Position grater that the size of the list ");
        }

        Node currentNode = first;
        Node prevNode = first;
        for(int i=1; position>i && currentNode != null; i++) {
            currentNode = currentNode.getNext();
            prevNode = currentNode;
        }

        X item = currentNode.getItem();
        prevNode.setNext( currentNode.getNext() );
        nodeCount--;
        return item;
    }

    public X get(int position){
        if (position > size()){
            throw new IllegalStateException("Position grater that the size of the list ");
        }

        Node currentNode = first;
        for(int i=1; i < size() && currentNode != null; i++) {
            if (i == position)
                return currentNode.getItem();
            currentNode = currentNode.getNext();
        }
        return null;
    }

    public int find(X item){

        Node currentNode = first;
        for(int i=1; i < size() && currentNode != null; i++) {
            if (currentNode.getItem().equals(item))
                return i;
            currentNode = currentNode.getNext();
        }

        return -1;
    }

    public String toString(){
        StringBuffer buffer = new StringBuffer();
        Node node = first;

        while (node!=null){

            buffer.append(node.getItem());
            node = node.getNext();

            if (node!=null)
                buffer.append(", ");
        }

        return buffer.toString();
    }

    private class Node {
        private Node next;
        private X item;

        public Node(X item){
            this.item = item;
            this.next = null;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public X getItem() {
            return item;
        }

        public void setItem(X item) {
            this.item = item;
        }
    }

}
