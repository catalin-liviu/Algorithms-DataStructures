package MyDataStructures;

import java.util.Iterator;


public class LinkedList<T> implements Iterable<T> {

    private Node first;

    private class Node {
        T item;
        Node link;
    }


    @Override
    public Iterator<T> iterator() {
        return new MyLinkedListIterator();
    }


    public void print() {

        for ( T item: this) {
            System.out.printf("%s", item.toString() + " ");
        }
    }


    public T get(int index) {
        MyLinkedListIterator iterator = new MyLinkedListIterator();
        T item = null;
        int listIndex = 0;

        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            return first.item;
        } else {
            while (iterator.hasNext()) {
                iterator.next();
                listIndex++;
                if (index == listIndex) {
                    item = iterator.current.item;
                }
            }
        }
        return item;
    }


    public void add(int index, T item) {
        Node newNode = new Node();
        newNode.item = item;
        Node nextNode;
        MyLinkedListIterator iterator = new MyLinkedListIterator();

        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            addFirst(newNode.item);
        } else if (index == size() - 1) {
            addLast(newNode.item);
        } else {
            for (int i = 0; i < index - 1; i++) {
                iterator.next();
            }
            nextNode = iterator.current.link;
            iterator.current.link = newNode;
            newNode.link = nextNode;

        }
    }


    public void addFirst(T item) {
        MyLinkedListIterator iterator = new MyLinkedListIterator();
        Node newNode = new Node();
        newNode.item = item;

        if (!iterator.hasNext()) {
            first = newNode;
        } else {
            newNode.link = first;
            first = newNode;
        }
    }


    public void addLast(T item) {
        MyLinkedListIterator iterator = new MyLinkedListIterator();
        Node newNode = new Node();
        newNode.item = item;

        if (iterator.hasNext()){
            while (iterator.current.link != null){
                iterator.current = iterator.current.link;
            }
            iterator.current.link = newNode;

        }else {
            first = newNode;
        }
    }


    public boolean contains(T item) {
        MyLinkedListIterator iterator = new MyLinkedListIterator();

        while (iterator.hasNext()) {
            if (iterator.next().equals(item)) {
                return true;
            }
        }
        return false;
    }


    public boolean isEmpty() {
        return size() == 0;
    }


    public int size() {
        MyLinkedListIterator iterator = new MyLinkedListIterator();
        int count = 0;

        while (iterator.hasNext()){
//            if(iterator.next() != null)
                iterator.next();
                count++;
        }
        return count;
    }


    public boolean remove(T item) {
        MyLinkedListIterator iterator = new MyLinkedListIterator();
        Node previous = null;

        while (iterator.hasNext()) {
            if (iterator.current.item.equals(item)) {
                if (previous == null) {
                    first = iterator.current.link;
                } else {
                    previous.link = iterator.current.link;
                }
            } else {
                previous = iterator.current;
            }
            iterator.current = iterator.current.link;
        }
        return true;
    }


    public void reverseList() {
        MyLinkedListIterator iterator = new MyLinkedListIterator();
        Node previousNode = null;
        Node nextNode;

        while (iterator.hasNext()) {
            nextNode = iterator.current.link;
            iterator.current.link = previousNode;
            previousNode = iterator.current;
            iterator.current = nextNode;
        }
        first = previousNode;
    }


    private class MyLinkedListIterator implements Iterator<T> {

        Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T item = current.item;
            current = current.link;
            return item;
        }
    }
}