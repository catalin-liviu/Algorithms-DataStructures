package MyDataStructures;

import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Created by catalin.dinu on 10/30/2017.
 */

public class Queue<T> implements Iterable<T>{

    private Node head;
    private Node tail;


    private class Node{
        T item;
        Node link;
    }


    public void print(){
        for (T item : this) {
            System.out.print(" " + item + "");
        }
    }


    public boolean isEmpty(){
        return head == null;
    }


    public int size(){
        int items = 0;
        for (T item: this) {
            items++;
        }
        return items;
    }


    public boolean contains(Object o){
       QueueIterator iterator = new QueueIterator();

       while (iterator.hasNext()) {
           if (iterator.next().equals(o)) {
               return true;
           }
       }
        return false;
    }


    public boolean add(T item){
        Node newNode = new Node();
        newNode.item = item;

        if(isEmpty()){
            head = tail = newNode;
        } else {
            tail.link = newNode;
            tail = newNode;
        }

        return false;
    }


    public boolean offer(T item){
        Node newNode = new Node();
        newNode.item = item;

        if(isEmpty()){
            head = tail = newNode;
        } else {
            tail.link = newNode;
            tail = newNode;
        }

        return true;
    }


    public T peek(){
        if(this.isEmpty()){
            return null;
        }
        return head.item;
    }


    public T element(){
        if(isEmpty()) {
            throw  new NoSuchElementException();
        }
        return head.item;
    }


    public T poll(){
        T item;

        if(this.isEmpty()) {
            return null;
        } else {
            item = head.item;
            head = head.link;
        }
        return item;
    }


    public T remove() {
        T item;

        if(this.isEmpty()) {
            throw new NoSuchElementException();
        } else {
            item = head.item;
            head = head.link;
        }
        return item;
    }


    @Override
    public Iterator<T> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<T> {
        Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T item = current.item;
            current = current.link;
            return item;
        }
    }
}
