package EdgeWeightedDigraph;

/**
 * Minimum-oriented indexed PQ implementation using a binary heap.
 * */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MinPQ<Key extends Comparable<Key>> implements Iterable{

    private static final int UNASSIGNED = -1;
    private int maximumElements;
    private int actualElementsNumber;
    private int[] priorityQueue;                   // binary heap, 1-based array represented
    private int[] heapTreeLevel;                   // helper array will hold the position of elements in the heap tree
    private Key[] keys;                 // will store priorities of elements in the heap


    /*
    * Class constructor will take the maximum number of elements as an argument
    * */
    public MinPQ(int maximumElements) {
        if (maximumElements < 0) {throw new IllegalArgumentException();}
        this.maximumElements = maximumElements;
        actualElementsNumber = 0;
        priorityQueue = new int[maximumElements + 1]; // initialized as 1-based indexed array
        heapTreeLevel = new int[maximumElements + 1]; // same initialization
        keys = (Key[]) new Comparable[maximumElements + 1];

        // set all index levels in the tree as UNASSIGNED
        for (int i = 0; i <= maximumElements; i++) {
            heapTreeLevel[i] =UNASSIGNED;
        }
    }

    public boolean isEmpty() {
        return actualElementsNumber == 0;
    }

    public int size() {
        return actualElementsNumber;
    }

    public boolean contains(int i) {
        if (i < 0 || i >= maximumElements) throw new IllegalArgumentException();
        // int i is in the tree if heapTreeLevel[i] is not -1;
        return heapTreeLevel[i] != UNASSIGNED;
    }


    /*
    * Inserts new element at a new index in the que and associates the key to the index
    * */
    public void insert(int i, Key key) {
        if (i < 0 || i >= maximumElements) {throw new IllegalArgumentException();}
        if (contains(i)) {throw new IllegalArgumentException("index is already in the priority queue");}
        // updates the elements in the heap
        actualElementsNumber++;

        heapTreeLevel[i] = actualElementsNumber;
        priorityQueue[actualElementsNumber] = i;
        keys[i] = key;
        swim(actualElementsNumber);
    }


    /*
    * Remove the minimum key and returns associated element from the queue head
    * */
    public int delMin() {
        if (actualElementsNumber == 0) throw new NoSuchElementException("Priority queue underflow");
        int min = priorityQueue[1];
        exchange(1, actualElementsNumber--);
        sink(1);
        heapTreeLevel[min] = UNASSIGNED;
        keys[min] = null;

        return min;
    }

    // Returns an index associated with a minimum key.
    public int minIndex() {
        if (actualElementsNumber == 0) throw new NoSuchElementException("Priority queue underflow");
        return priorityQueue[1];
    }
    // Returns a minimum key.
    public Key minKey() {
        if (actualElementsNumber == 0) throw new NoSuchElementException("Priority queue underflow");
        return keys[priorityQueue[1]];
    }

    /*
     * Returns the key associated with index
     */
    public Key keyOf(int i) {
        if (i < 0 || i >= maximumElements) throw new IllegalArgumentException();
        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
        else return keys[i];
    }

    /*
     * Change the key associated with index to the specified value.
     */
    public void changeKey(int i, Key key) {
        if (i < 0 || i >= maximumElements) throw new IllegalArgumentException();
        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
        keys[i] = key;
        swim(heapTreeLevel[i]);
        sink(heapTreeLevel[i]);
    }


    /*
     * Decrease the key associated with index {@code i} to the specified value.
     */
    public void decreaseKey(int i, Key key) {
        if (i < 0 || i >= maximumElements) {throw new IllegalArgumentException();}
        if (!contains(i)) {throw new NoSuchElementException("index is not in the priority queue");}
        if (keys[i].compareTo(key) <= 0) {
            throw new IllegalArgumentException("Calling decreaseKey() with given argument would not strictly decrease the key");
        }
        keys[i] = key;
        swim(heapTreeLevel[i]);
    }

    /*
     * Increase the key associated with index {@code i} to the specified value.
     */
    public void increaseKey(int i, Key key) {
        if (i < 0 || i >= maximumElements) {throw new IllegalArgumentException();}
        if (!contains(i)) {throw new NoSuchElementException("index is not in the priority queue");}
        if (keys[i].compareTo(key) >= 0) {
            throw new IllegalArgumentException("Calling increaseKey() with given argument would not strictly increase the key");
        }
        keys[i] = key;
        sink(heapTreeLevel[i]);
    }



    /*
    * Heap management methods
    * */
    private void swim(int k) {
        // while k is not at the root and parent's key is greater than k's key exchange and update tree position
        while (k > 1 && greater(k/2, k)) {
            exchange(k, k/2);
            k = k/2;
        }
    }
    private void sink(int k) {
        while (2*k <= actualElementsNumber) {
            int j = 2*k;
            if (j < actualElementsNumber && greater(j, j+1)) {
                j++;
            }
            if (!greater(k, j)) {
                break;
            }
            exchange(k, j);
            k = j;
        }
    }




    /*
    * Heap management helper methods
    * */
    private boolean greater(int i, int j) {
        return keys[priorityQueue[i]].compareTo(keys[priorityQueue[j]]) > 0 ;
    }

    private void exchange(int i, int j) {
        // swap
        int temp = priorityQueue[i];
        priorityQueue[i] = priorityQueue[j];
        priorityQueue[j] = temp;
        // update the heap tree
        heapTreeLevel[priorityQueue[i]] = i;
        heapTreeLevel[priorityQueue[j]] = j;
    }




    /*
    * Returns an iterator that iterates over the keys on the priority queue
    * */
    @Override
    public Iterator iterator() {
        return new HeapIterator();
    }

    private class HeapIterator implements Iterator<Integer> {

        private MinPQ<Key> copy;

        public HeapIterator() {
            // populate the copy of pq
            copy = new MinPQ<Key>(priorityQueue.length -1 );
            for (int i = 1; i <= actualElementsNumber; i++) {
                copy.insert(priorityQueue[i], keys[priorityQueue[i]]);
            }
        }

        @Override
        public boolean hasNext() {
            return !copy.isEmpty();
        }

        @Override
        public Integer next() {
            if (!hasNext()){throw new NoSuchElementException();}
            return copy.delMin();
        }
    }
}
