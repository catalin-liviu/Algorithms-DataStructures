package MyDataStructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by catalin.dinu on 10/31/2017.
 */

public class Stack<T> implements Iterable<T>{

    private Node head;

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private class Node {
        T item;
        Node link;
    }

    public void print(){

        for (T item : this) {
            System.out.print(" " + item + "");
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        StackIterator iterator = new StackIterator();
        int items = 0;
        for (T item: this) {
            items++;
        }
        return items;
    }

    public boolean contains(Object o) {
        StackIterator iterator = new StackIterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(o)) {
                return true;
            }
        }
        return false;
    }

    public void push(T item){
        Node newNode;

        if (isEmpty()){
            newNode = new Node();
            newNode.item = item;
            head = newNode;
        } else {
            Node oldhead = this.head;
            head = new Node();
            head.item = item;
            head.link = oldhead;
        }

    }

    public T peek(){
        return head.item;
    }


    public T pop() {
        T item = head.item;
        head = head.link;
        return item;
    }

    public int search(Object o) {
        StackIterator iterator = new StackIterator();
        int index = 0;
        while (iterator.hasNext()) {
            if ( iterator.next().equals(o)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    private class StackIterator implements Iterator<T> {
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
