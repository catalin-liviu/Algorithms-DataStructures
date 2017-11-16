package MyDataStructuresTests;



import MyDataStructures.Queue;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by catalin.dinu on 10/30/2017.
 */

public class QueueTest {

    @Test
    public void testOffer_should_add_an_item_on_the_queue_tail() {
        Queue<Integer> queue = new Queue<>();
        Assert.assertTrue(queue.isEmpty());
        Assert.assertTrue(queue.size() == 0);

        queue.offer(0);
        Assert.assertTrue(!queue.isEmpty());
        Assert.assertTrue(queue.size() == 1);

        for (int i = 1; i <= 19  ; i++) {
            queue.offer(i);
        }

        Assert.assertTrue(queue.size() == 20);
        Assert.assertTrue(queue.contains(19));
        Assert.assertTrue(!queue.contains(20));
    }

    @Test
    public void testPoll_should_remove_the_head_element_and_retrieve_the_item() {
        Queue<Integer> queue = new Queue<>();
        Assert.assertTrue(queue.isEmpty());
        Assert.assertTrue(queue.size() == 0);

        for (int i = 0; i < 20; i++) {
            queue.offer(i);
        }

        Assert.assertTrue(queue.size() == 20);
        queue.poll();
        Assert.assertTrue(queue.size() == 19);
        Assert.assertTrue(queue.peek() == 1);
        queue.offer(20);

        for (int i = 1; i < 6; i++) {
            queue.poll();
        }

        Assert.assertTrue(queue.size() == 15);
        Assert.assertTrue(queue.peek() == 6);

    }
}
