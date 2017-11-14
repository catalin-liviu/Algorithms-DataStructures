package UnitTestP_AL_vs_LL;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
/**
 * Created by catalin.dinu on 10/31/2017.
 */

public class UnitTest {

    ArrayList<Integer> intsArrayList;

    @Test
    public void testAddAndIterationOverLinkedList() {

        LinkedList<Integer> intsLinkedList = new LinkedList<>();
        int count = 0;


        for (int i = 0; i < 300000; i++) {
            intsLinkedList.add(i);
        }

        for (int i : intsLinkedList) {
            count++;
        }
        System.out.println(count);


      for(Iterator iterator = intsLinkedList.iterator(); iterator.hasNext();){
          int i = 0;
          while (i < intsLinkedList.size()) {
              intsLinkedList.remove(i);
              i++;
          }
      }
        System.out.println(intsLinkedList.toString());
    }

    @Test
    public void testAddAndIterationOverArrayList() {
        ArrayList<Integer> intsArrayList = new ArrayList<>();
        int count = 0;


        for (int i = 0; i < 300000; i++) {
            intsArrayList.add(i);
        }

        for (int i : intsArrayList) {
            count++;
        }
        System.out.println(count);


        for(Iterator iterator = intsArrayList.iterator(); iterator.hasNext();){
            int i = 0;
            while (i < intsArrayList.size()) {
                intsArrayList.remove(i);
                i++;
            }
        }
        System.out.println(intsArrayList.toString());
    }


}

