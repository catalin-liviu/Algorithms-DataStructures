package MyDataStructuresTests;


import MyDataStructures.Stack;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by catalin.dinu on 10/31/2017.
 */

public class StackTest {

    @Test
    public void testSearch_Should_Retrieve_The_Index_In_Stack (){
        Stack<String> myStack = new Stack<>();
        myStack.push("first");
        myStack.push("second");
        myStack.push("third");
        myStack.push("fourth");
        myStack.push("fifth");
        myStack.push("sixth");


       Assert.assertTrue(myStack.pop().equals("sixth"));
       Assert.assertTrue(myStack.peek().equals("fifth"));
        Assert.assertTrue(myStack.pop().equals("fifth"));
        Assert.assertTrue(myStack.peek().equals("fourth"));
        myStack.print();
        int index = myStack.search("sixth");
        System.out.println(index);
    }

}
