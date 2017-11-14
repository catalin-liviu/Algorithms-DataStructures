package MyDataStructures;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Created by catalin.dinu on 11/2/2017.
 */

public class Bag<T> implements Iterable<T> {

    private int n; // number of elements
    private Node<T> first;

    // helper class
    private class Node<T> {
        public T item;
        Node link;
    }

    // Constructor
    public Bag() {
        n = 0;
        first = null;
    }


    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }


    public void add(T item) {
        if(first == null){
            Node<T> newNode = new Node<T>();
            newNode.item = item;
            first = newNode;
            n++;
        } else {
            Node<T> oldfirst = first;
            first = new Node();
            first.item = item;
            first.link = oldfirst;
            n++;
        }
    }


    @Override
    public Iterator<T> iterator() {
        return new BagIterator();
    }


    private class BagIterator implements Iterator {
        Node<T> current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            T item = current.item;
            current = current.link;
            return item;
        }
    }
}
