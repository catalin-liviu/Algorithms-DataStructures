package GraphTesting;


import DirectedGraph.*;
import EdgeWeightedDigraph.DirectedGraphAdjListRepresented;
import MyDataStructures.Bag;
import MyDataStructures.LinkedList;
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
        BFS bfs = new BFS(G, 7);

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
        DFS dfs = new DFS(G, 7);

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
    public void testCyclicDirectedGraph() {
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
        CycleFinder cycleFinder = new CycleFinder(G);

        /*
        * Asserts if the graph contain cycles
        * If finds one, it prints it out
        * */
        Assert.assertTrue(cycleFinder.hasCycle());
        System.out.print("Graph has direct cycles - Ex: ");
        System.out.println(cycleFinder.cycle().toString());
    }

    @Test
    public void testAcyclicDirectedGraph() {
        DirectedGraphAdjListRepresented G = new DirectedGraphAdjListRepresented(13);
        G.addEdge(0,1); G.addEdge(0,5); G.addEdge(0,6); G.addEdge(2,3);
        G.addEdge(2,0); G.addEdge(3,5); G.addEdge(5,4); G.addEdge(6,4);
        G.addEdge(6,9); G.addEdge(7,6); G.addEdge(8,7); G.addEdge(9,10);
        G.addEdge(9,11); G.addEdge(9,12); G.addEdge(11,12);

        /**
         * Starts the cycle search
         * */
        CycleFinder cycleFinder = new CycleFinder(G);

        Assert.assertTrue(!cycleFinder.hasCycle());
        if (!cycleFinder.hasCycle()) {
            System.out.println("Directed Acyclic Graph");
        }
    }

    @Test
    public void testTopoligicalSort() {
        DirectedGraphAdjListRepresented G = new DirectedGraphAdjListRepresented(13);
        G.addEdge(0,1); G.addEdge(0,5); G.addEdge(0,6); G.addEdge(2,3);
        G.addEdge(2,0); G.addEdge(3,5); G.addEdge(5,4); G.addEdge(6,4);
        G.addEdge(6,9); G.addEdge(7,6); G.addEdge(8,7); G.addEdge(9,10);
        G.addEdge(9,11); G.addEdge(9,12); G.addEdge(11,12);


        /**
         * Order graph using Depth First Algorithm
         * */
        TopologicalSort topologicalSort = new TopologicalSort(G);
        LinkedList<Integer> topologicSortedList = topologicalSort.sort();
        Assert.assertTrue(topologicSortedList.get(4) == 0);
        Assert.assertTrue(topologicSortedList.get(topologicSortedList.size()-1) == 12);

    }

    @Test
    public void testReverse_should_reverse_the_edges_direction() {
        DirectedGraphAdjListRepresented G = new DirectedGraphAdjListRepresented(13);
        G.addEdge(0,1); G.addEdge(0,5); G.addEdge(0,6); G.addEdge(2,3);
        G.addEdge(2,0); G.addEdge(3,5); G.addEdge(5,4); G.addEdge(6,4);
        G.addEdge(6,9); G.addEdge(7,6); G.addEdge(8,7); G.addEdge(9,10);
        G.addEdge(9,11); G.addEdge(9,12); G.addEdge(11,12);


        DirectedGraphAdjListRepresented reversedG = G.reverse();
        Bag<Integer> adjOfNode6 = (Bag<Integer>) reversedG.adj(6);
        Assert.assertTrue(adjOfNode6.contains(0) && adjOfNode6.contains(7));
        Bag<Integer> adjOfNode12 = (Bag<Integer>) reversedG.adj(12);
        Assert.assertTrue(adjOfNode12.contains(11) && adjOfNode12.contains(9));
        Bag<Integer> adjOfNode2 = (Bag<Integer>) reversedG.adj(2);
        Assert.assertTrue(adjOfNode2.isEmpty());
    }

}
