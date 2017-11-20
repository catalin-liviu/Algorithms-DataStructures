package UnitTestP_AL_vs_LL;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by catalin.dinu on 10/31/2017.
 */

public class UnitTest {

    ArrayList<Integer> intsArrayList;

    @Test
    public void testAddAndIterationOverLinkedList() {
        LinkedList<Integer> intsLinkedList = new LinkedList<>();
        run(intsLinkedList);
    }

    @Test
    public void testAddAndIterationOverArrayList() {
        ArrayList<Integer> intsArrayList = new ArrayList<>();
        run(intsArrayList);
    }

    private void run(List<Integer> list) {
        int count = 0;
        for (int i = 0; i < 200000; i++) {
            list.add(i);
        }

        for (int i : list) {
            count++;
        }
        System.out.println(count);

        for(Iterator iterator = list.iterator(); iterator.hasNext();){
            int i = 0;
            while (i < list.size()) {
                list.remove(i);
                i++;
            }
        }
        System.out.println(list.toString());
    }

}

