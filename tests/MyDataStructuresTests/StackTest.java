package MyDataStructuresTests;


import MyDataStructures.Stack;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by catalin.dinu on 10/31/2017.
 */

public class StackTest {

    @Test
    public void testPush_should_add_item_on_top_of_the_stack() {
        Stack<Integer> stack = new Stack<>();
        Assert.assertTrue(stack.isEmpty());
        Assert.assertTrue(stack.size() == 0);

        stack.push(0);
        Assert.assertFalse(stack.isEmpty());
        Assert.assertTrue(stack.size() == 1);
        Assert.assertTrue(stack.contains(0));


        for (int i = 1; i < 11; i++) {
            stack.push(i);
        }

        Assert.assertTrue(stack.size() == 11);
        Assert.assertTrue(stack.contains(10));
        Assert.assertTrue(stack.search(10) == 0);
        Assert.assertTrue(stack.peek() == 10);
        Assert.assertTrue(stack.search(8) == 2);
    }

    @Test
    public void testPop_should_remove_the_top_item_from_the_stack() {
        Stack<Integer> stack = new Stack<>();
        Assert.assertTrue(stack.isEmpty());
        Assert.assertTrue(stack.size() == 0);

        for (int i = 0; i < 20; i++) {
            stack.push(i);
        }

        for (int i = 0; i < 10; i++) {
            stack.pop();
        }

        Assert.assertTrue(stack.size() == 10);
        Assert.assertTrue(stack.peek() == 9);
        Assert.assertTrue(stack.search(9) == 0);

        stack.pop();
        Assert.assertTrue(stack.peek() == 8);
    }
}
