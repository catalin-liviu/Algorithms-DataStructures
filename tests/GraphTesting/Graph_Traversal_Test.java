package GraphTesting;


import UndirectedGraph.BFS;
import UndirectedGraph.DFS;
import UndirectedGraph.UndirectedGraphAdjListRepresented;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by catalin.dinu on 11/3/2017.
 */

public class Graph_Traversal_Test {

    @Test
    public void testDFS() {
        UndirectedGraphAdjListRepresented G = new UndirectedGraphAdjListRepresented(13);
        G.addEdge(0,1); G.addEdge(0,2); G.addEdge(0,5); G.addEdge(0,6);
        G.addEdge(2,3); G.addEdge(3,5); G.addEdge(4,5); G.addEdge(4,6);
        G.addEdge(6,7); G.addEdge(6,9); G.addEdge(7,8); G.addEdge(9,10);
        G.addEdge(9,11); G.addEdge(9,12); G.addEdge(11,12);

        G.addEdge(1,10);

        System.out.println(G);
        Assert.assertTrue(G.V() == 13);
        System.out.println("Vertices Number - Assert Successful");
        Assert.assertTrue(G.E() == 16);
        System.out.println("Edges Number - Assert Successful");


        /*
        * path search
        * */
        DFS processDFS = new DFS(G, 0);
        BFS processBFS = new BFS(G, 0);



        /*
        * show path from source to a given vertex
        * */
        System.out.println("Path - from destination to source" + processDFS.pathTo(10).toString());
        System.out.println("Path - from destination to source" + processDFS.pathTo(5).toString());

        /*
        * show the shortest path from source to a given vertex
        * */
        System.out.println("Shortest Path - from destination to source" + processBFS.pathTo(10).toString());
        System.out.println("Shortest Path - from destination to source" + processBFS.pathTo(5).toString());

        int i = 0;
        while (i <= 100) {
            int steps = -1;
            for (int x: processBFS.pathTo(5)) {
                steps++;
            }
            Assert.assertTrue(steps == 1);
            i++;
        }


        /*
        * Confirms that every vertex in the path, has been visited
        * */
        for (int x : processDFS.pathTo(12)) {
            boolean[] markedCopy = processDFS.getMarked();
            Assert.assertTrue(markedCopy[x] = true);
            System.out.printf(x + ", ");
            System.out.println(markedCopy[x] + ", vertix visited");

        }

    }
}
