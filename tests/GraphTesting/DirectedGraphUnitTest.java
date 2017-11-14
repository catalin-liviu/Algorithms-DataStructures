package GraphTesting;


import DirectedGraph.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by catalin.dinu on 11/8/2017.
 */

public class DirectedGraphUnitTest {

    @Test
    public void testBFS_find_shortest_path() {

        DirectedGraphAdjListRepresented G = new DirectedGraphAdjListRepresented(13);
        G.addEdge(0,1); G.addEdge(0,5); G.addEdge(2,0); G.addEdge(2,3);
        G.addEdge(3,2); G.addEdge(3,5); G.addEdge(4,2); G.addEdge(4,3);
        G.addEdge(5,4); G.addEdge(6,0); G.addEdge(6,4); G.addEdge(6,8);
        G.addEdge(6,9); G.addEdge(7,6); G.addEdge(7,9); G.addEdge(8,6);
        G.addEdge(9,10); G.addEdge(9,11); G.addEdge(10,12);
        G.addEdge(11,4); G.addEdge(11,12); G.addEdge(12,9);

        /**
        * Assert number of vertices and edges in G
        * */
        Assert.assertTrue(G.V() == 13);
        System.out.printf("Graph G has %d vertices\n", G.V());
        Assert.assertTrue(G.E() == 22);
        System.out.printf("Graph G has %d edges\n", G.E());

        /**
        * Started BFS
        * */
        DirectedBFS bfs = new DirectedBFS(G, 7);

        // tested if bfs returns the shortest path
        Assert.assertTrue(bfs.hasPathTo(1));
        if(bfs.hasPathTo(1)) {
            Assert.assertTrue(bfs.distTo(1) == 3);
            System.out.println(bfs.pathTo(1).toString());
        }
    }

    @Test
    public void testDFS() {

        DirectedGraphAdjListRepresented G = new DirectedGraphAdjListRepresented(13);
        G.addEdge(0,1); G.addEdge(0,5); G.addEdge(2,0); G.addEdge(2,3);
        G.addEdge(3,2); G.addEdge(3,5); G.addEdge(4,2); G.addEdge(4,3);
        G.addEdge(5,4); G.addEdge(6,0); G.addEdge(6,4); G.addEdge(6,8);
        G.addEdge(6,9); G.addEdge(7,6); G.addEdge(7,9); G.addEdge(8,6);
        G.addEdge(9,10); G.addEdge(9,11); G.addEdge(10,12);
        G.addEdge(11,4); G.addEdge(11,12); G.addEdge(12,9);

        /**
         * Started DFS
         * */
        DirectedDFS dfs = new DirectedDFS(G, 7);

        /*
        * If there is path from s to dest
        * prints the path
        * and also the number of vertices accessible from source
        * */
        Assert.assertTrue(dfs.hasPathTo(1));
        if (dfs.hasPathTo(1)) {
            System.out.println(dfs.pathTo(1));
            System.out.println(dfs.count());
        }
    }

    @Test
    public void testIfDAG() {
        DirectedGraphAdjListRepresented G = new DirectedGraphAdjListRepresented(13);
        G.addEdge(0,1); G.addEdge(0,5); G.addEdge(2,0); G.addEdge(2,3);
        G.addEdge(3,2); G.addEdge(3,5); G.addEdge(4,2); G.addEdge(4,3);
        G.addEdge(5,4); G.addEdge(6,0); G.addEdge(6,4); G.addEdge(6,8);
        G.addEdge(6,9); G.addEdge(7,6); G.addEdge(7,9); G.addEdge(8,6);
        G.addEdge(9,10); G.addEdge(9,11); G.addEdge(10,12);
        G.addEdge(11,4); G.addEdge(11,12); G.addEdge(12,9);

        /**
         * Starts the cycle search
         * */
        CycleFinderDFS cycleFinderDFS = new CycleFinderDFS(G);

        /*
        * Asserts if the graph contain cycles
        * If finds one, it prints it out
        * */
        Assert.assertTrue(cycleFinderDFS.hasCycle());
        System.out.print("Graph has direct cycles - Ex: ");
        System.out.println(cycleFinderDFS.cycle().toString());
    }

    @Test
    public void testIFDAG() {
        DirectedGraphAdjListRepresented G = new DirectedGraphAdjListRepresented(13);
        G.addEdge(0,1); G.addEdge(0,5); G.addEdge(0,6); G.addEdge(2,3);
        G.addEdge(2,0); G.addEdge(3,5); G.addEdge(5,4); G.addEdge(6,4);
        G.addEdge(6,9); G.addEdge(7,6); G.addEdge(8,7); G.addEdge(9,10);
        G.addEdge(9,11); G.addEdge(9,12); G.addEdge(11,12);

        /**
         * Starts the cycle search
         * */
        CycleFinderDFS cycleFinderDFS = new CycleFinderDFS(G);

        Assert.assertTrue(!cycleFinderDFS.hasCycle());
        if (!cycleFinderDFS.hasCycle()) {
            System.out.println("Directed Acyclic Graph");
        }

        /**
        * Order grapth using Depth First Algorithm
        * */
        DirectedDFOrder dfsOrder = new DirectedDFOrder(G);
        dfsOrder.topologicalSortDisplay();


    }


}
