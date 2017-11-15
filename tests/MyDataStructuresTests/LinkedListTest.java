package MyDataStructuresTests;



import MyDataStructures.LinkedList;
import org.junit.Assert;
import org.junit.Test;

public class LinkedListTest {

    @Test
    public void testConstructor(){
        System.out.println("\ntestConstructor");
        LinkedList list = new LinkedList();

        Assert.assertNotNull(list);
        Assert.assertTrue(list.size() == 0);
        Assert.assertFalse(list.contains(2));
    }

    @Test
    public void testPrint(){
        System.out.println("\ntestPrint");
        LinkedList list = new LinkedList();

        list.addFirst(1);
        list.addFirst(0);
        list.addFirst(1);
        list.print();
        System.out.println();
    }

    @Test
    public void testGet(){

        LinkedList<String> list =  new LinkedList<>();
        list.addFirst("to");
        list.addLast("be");
        list.addLast("or");
        list.addLast("not");
        list.addLast("to");
        list.addLast("be");
        list.addLast(", ");
        list.addLast("that");
        list.addLast("is");
        list.addLast("the");
        list.addLast("question");

        String item = list.get(2);
        System.out.println(item);
        int size = list.size();
        System.out.println(size);
        Assert.assertTrue(item == "or");

        for (String s : list) {
            System.out.printf("%s ", s);
        }
    }

    @Test
    public void testAdd(){
        System.out.println("testAdd");
        LinkedList list = new LinkedList();
        list.addFirst(0);
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.addLast(7);
        list.addLast(8);
        list.addLast(9);
        list.addLast(10);
        list.addLast(11);
        list.addLast(12);
        list.addLast(13);
        list.addFirst(1111);
        list.print();
        System.out.println();

        list.add(0, 1000);
        list.print();


    }

    @Test
    public void testAddLast(){
        System.out.println("testAddLast");
        LinkedList list = new LinkedList();

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addFirst(0);
        list.print();
        System.out.println();

        //Asserts
        Assert.assertTrue(!list.isEmpty());
        Assert.assertTrue(4 == list.size());
    }

    @Test
    public void testRemove(){
        System.out.println("testRemove");
        LinkedList list = new LinkedList();
        list.addFirst(0);
        list.addLast(0);
        list.addLast(7);
        list.addFirst(5);

        boolean hasItem = list.contains(3);
        Assert.assertFalse(hasItem);

        list.addLast(7);
        Assert.assertTrue(list.contains(7));
        list.print();
        System.out.println();

        list.add(0,5);
        list.print();
        list.remove(5);
        System.out.println();
        list.print();
        list.remove(7);
        System.out.println();
        list.print();
    }

    @Test
    public void testSize(){
        System.out.println("testSize");
        LinkedList list = new LinkedList();
        list.addFirst(0);
        list.addLast(7);
        list.addLast(7);

        Assert.assertTrue(!list.isEmpty());
        Assert.assertTrue(list.size() == 3);
    }

    @Test
    public void testIsEmpty(){
        System.out.println("\ntestIsEmpty");
        LinkedList list = new LinkedList();

        Assert.assertNotNull("List instantiated", list);
        Assert.assertTrue(list.size() == 0);
    }

    @Test
    public void testContains(){
        System.out.println("testContains");
        LinkedList list = new LinkedList();
        Assert.assertTrue(list.isEmpty());

        list.addLast(8);
        list.addFirst(0);
        list.print();
        System.out.println();

        Assert.assertFalse(list.isEmpty());
        Assert.assertTrue(list.contains(8));
        Assert.assertTrue(list.contains(0));
        Assert.assertFalse(list.contains(100));
    }

    @Test
    public void testReverseList(){
        System.out.println("testReverseList");
        LinkedList<Integer> list = new LinkedList();

        for(int i = 0; i < 20; i++){
            list.add(i, i);
        }
        list.print();
        list.reverseList();
        System.out.println();

        for (Integer i : list) {
            System.out.printf("%d ", i);
        }

    }
}