package MyDataStructures;

/**
 * Created by catalin.dinu on 10/31/2017.
 */

public class Stack<T> {

    private Node head;
    private Node last;

    private class Node {
        T item;
        Node link;
    }

    public void print(){

        Node it = head;
        while (it != null){
            System.out.println(it.item);
            it = it.link;
        }

    }

    public boolean isEmpty() {
        return head == null;
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
        Node it = head;
        int index = 0;
        while (it != null) {
            if ( it.item.equals(o)) {
                return index;
            }
            it = it.link;
            index++;
        }
        return -1;
    }
}
