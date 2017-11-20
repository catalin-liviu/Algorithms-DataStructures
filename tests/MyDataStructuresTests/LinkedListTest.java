package MyDataStructuresTests;



import MyDataStructures.LinkedList;
import org.junit.Assert;
import org.junit.Test;

public class LinkedListTest {

    @Test
    public void testAdd_should_add_item_at_specified_index() {
        LinkedList<Integer> linkedList = new LinkedList<>();

        Assert.assertTrue(linkedList.isEmpty());
        Assert.assertTrue(linkedList.size() == 0);

        linkedList.add(0, 0);
        Assert.assertTrue(!linkedList.isEmpty());
        Assert.assertTrue(linkedList.size() == 1);

        linkedList.add(1, 1);
        linkedList.add(2, 2);
        linkedList.add(3, 3);
        linkedList.add(4, 4);
        linkedList.add(5, 5);
        linkedList.add(6, 6);
        linkedList.add(7, 7);
        linkedList.add(8, 8);
        linkedList.add(9, 9);
        linkedList.add(10, 10);
        linkedList.add(11, 1000);

        Assert.assertTrue(linkedList.size() == 12);
        Assert.assertTrue(linkedList.contains(1000));

        int lastIndex = linkedList.size()-1;
        Assert.assertTrue(linkedList.get(lastIndex) == 1000);
    }


    @Test
    public void testGet_should_return_the_element_at_specified_index() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 1000; i++) {
            linkedList.add(i, i);
        }
        Assert.assertTrue(linkedList.get(700) == 700);
        linkedList.add(700, 777);
        Assert.assertTrue(linkedList.get(700) == 777);
        Assert.assertTrue(linkedList.get(701) == 700);
        Assert.assertTrue(linkedList.size() == 1001);
        linkedList.addFirst(1000);
        Assert.assertTrue(linkedList.get(701) == 777);
        Assert.assertTrue(linkedList.size() == 1002);
    }

    @Test
    public void testRemove_should_remove_item_from_list() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 1000; i++) {
            linkedList.add(i, i);
        }

        linkedList.remove(500);
        Assert.assertTrue(linkedList.size() == 999);
        Assert.assertTrue(!linkedList.contains(500));
        Assert.assertTrue(linkedList.contains(999));
        linkedList.remove(999);
        int lastItemIndex = linkedList.size() - 1;
        Assert.assertTrue(linkedList.get(lastItemIndex) == 998);
        linkedList.addLast(10000);
        Assert.assertTrue(linkedList.get(linkedList.size() - 1) == 10000);
    }

    @Test
    public void testReverseList_should_reverse_the_list() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 50; i++) {
            linkedList.add(i, i);
        }
        linkedList.reverseList();

        Assert.assertTrue(linkedList.get(0) == 49);
        Assert.assertTrue(linkedList.get(linkedList.size() / 2) == 24);
    }
}