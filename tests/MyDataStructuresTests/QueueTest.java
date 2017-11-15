package MyDataStructuresTests;



import MyDataStructures.Queue;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by catalin.dinu on 10/30/2017.
 */

public class QueueTest {

    @Test
    public void testPrint(){
        Queue queue = new Queue();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.print();
    }


    @Test
    public void testIsEmpty(){
        Queue queue = new Queue();
        queue.offer(1);
        queue.offer(2);
        queue.offer(2);
        queue.offer(2);
        queue.offer(8);
        int size = queue.size();

        Assert.assertTrue(size == 5);

    }

    @Test
    public void testContains(){
        Queue queue = new Queue();
        queue.offer(1);
        queue.offer(1);
        queue.offer(200);
        queue.offer(2);
        queue.offer(5);
        queue.print();
        Assert.assertTrue(queue.contains(200));
    }

    @Test
    public void testAdd(){
        Queue<Integer> queue = new Queue();
        queue.add(0);
        queue.print();
        System.out.println();
        queue.add(1);
        queue.add(2);
        queue.print();
        boolean insertSuccesful = queue.contains(1);
        Assert.assertTrue(insertSuccesful);
    }

    @Test
    public void testOffer(){
        Queue<Integer> queue = new Queue();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.print();
        int headElement = queue.element();
        System.out.println();
        System.out.println(headElement);
        boolean insertSuccessful = queue.contains(1);
        Assert.assertTrue(insertSuccessful);

    }

    @Test
    public void testPeek(){
        Queue<Integer> queue = new Queue();
        queue.offer(8);
        queue.offer(3);
        queue.offer(1);

        int item = queue.peek();
        Assert.assertTrue(item == 8);
        queue.print();
        queue.remove();
        System.out.println();
        queue.print();
        Assert.assertTrue(!queue.isEmpty());

    }

    @Test
    public void testPoll(){
        Queue<Integer> queue = new Queue();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);

        int item = queue.peek();
        Assert.assertTrue(item == 1);
        int item1 = queue.poll();
        Assert.assertTrue(item1 == 1);
        Assert.assertFalse(queue.isEmpty());
        int item2 = queue.poll();
        Assert.assertTrue(item2 == 2);
        Assert.assertFalse(queue.isEmpty());
        queue.print();
    }

    @Test
    public void testRemove(){
        Queue<Integer> queue = new Queue();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);

        int item1 = queue.remove();
        Assert.assertTrue(item1 == 1);
        int queueHead = queue.peek();
        Assert.assertTrue(queueHead == 2);
        queue.remove();
        queue.remove();
        Assert.assertTrue(queue.peek() == 4);
    }

}
