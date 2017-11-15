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
        UndirectedGraphAdjListRepresented graph = new UndirectedGraphAdjListRepresented(13);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 4);
        graph.addEdge(1, 5);
        graph.addEdge(4, 3);
        graph.addEdge(3, 6);
        graph.addEdge(3, 7);
        graph.addEdge(5, 6);
        graph.addEdge(6, 7);
        graph.addEdge(7, 8);
        graph.addEdge(8, 9);
        graph.addEdge(8, 10);
        graph.addEdge(4, 10);
        graph.addEdge(2, 11);
        graph.addEdge(11, 12);
        graph.addEdge(2, 9);

        System.out.println(graph);
        Assert.assertTrue(graph.V() == 13);
        System.out.println("Vertices Number - Assert Successful");
        Assert.assertTrue(graph.E() == 16);
        System.out.println("Edges Number - Assert Successful");


        /*
        * path search
        * */
        DFS processDFS = new DFS(graph, 0);
        BFS processBFS = new BFS(graph, 0);



        /*
        * show path from source to a given vertex
        * */
        System.out.println("Path - from destination to source" + processDFS.pathTo(10).toString());
        System.out.println("Path - from destination to source" + processDFS.pathTo(7).toString());

        /*
        * show the shortest path from source to a given vertex
        * */
        System.out.println("Shortest Path - from destination to source" + processBFS.pathTo(10).toString());
        System.out.println("Shortest Path - from destination to source" + processBFS.pathTo(7).toString());

        int i = 0;
        while (i <= 50) {
            int steps = -1;
            for (int x: processBFS.pathTo(10)) {
                steps++;
            }
            Assert.assertTrue(steps == 3);
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
