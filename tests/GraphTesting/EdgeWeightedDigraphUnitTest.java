package GraphTesting;

import DirectedGraph.EdgeWeightedDirectedGraph;
import EdgeWeightedDigraph.BellmanFordSP;
import EdgeWeightedDigraph.DijkstrasSP;
import EdgeWeightedDigraph.DirectedEdge;
import MyDataStructures.Stack;
import org.junit.Assert;
import org.junit.Test;


public class EdgeWeightedDigraphUnitTest {

    @Test
    public void testDijkstraShortestPath() {
        EdgeWeightedDirectedGraph G = new EdgeWeightedDirectedGraph(8);
        G.addEdge(new DirectedEdge(4, 5, 0.35)); G.addEdge(new DirectedEdge(5, 4, 0.35));
        G.addEdge(new DirectedEdge(4, 7, 0.37)); G.addEdge(new DirectedEdge(5, 7, 0.28));
        G.addEdge(new DirectedEdge(7, 5, 0.28)); G.addEdge(new DirectedEdge(5, 1, 0.32));
        G.addEdge(new DirectedEdge(0, 4, 0.38)); G.addEdge(new DirectedEdge(0, 2, 0.26));
        G.addEdge(new DirectedEdge(7, 3, 0.39)); G.addEdge(new DirectedEdge(1, 3, 0.29));
        G.addEdge(new DirectedEdge(2, 7, 0.34)); G.addEdge(new DirectedEdge(6, 2, 0.40));
        G.addEdge(new DirectedEdge(3, 6, 0.52)); G.addEdge(new DirectedEdge(6, 0, 0.58));
        G.addEdge(new DirectedEdge(6, 4, 0.93));


        // compute shortest paths
        DijkstrasSP dsp = new DijkstrasSP(G, 0);

        Assert.assertTrue(dsp.hasPathTo(3));
        Assert.assertTrue(dsp.distTo(3) < 1 && dsp.distTo(3) > 0.99);
        Assert.assertTrue(dsp.distTo(4) == 0.38);
        Stack stack = (Stack) dsp.pathTo(4);
        Assert.assertTrue(stack.size() == 1);
        Stack stack1 = (Stack) dsp.pathTo(6);
        Assert.assertTrue(stack1.size() == 4);
        Assert.assertTrue(G.V() == 8);

    }

    @Test
    public void testBellmanFordShortestPath() {
        EdgeWeightedDirectedGraph G = new EdgeWeightedDirectedGraph(8);
        G.addEdge(new DirectedEdge(4, 5, 0.35)); G.addEdge(new DirectedEdge(5, 4, 0.35));
        G.addEdge(new DirectedEdge(4, 7, 0.37)); G.addEdge(new DirectedEdge(5, 7, 0.28));
        G.addEdge(new DirectedEdge(7, 5, 0.28)); G.addEdge(new DirectedEdge(5, 1, 0.32));
        G.addEdge(new DirectedEdge(0, 4, 0.38)); G.addEdge(new DirectedEdge(0, 2, 0.26));
        G.addEdge(new DirectedEdge(7, 3, 0.39)); G.addEdge(new DirectedEdge(1, 3, 0.29));
        G.addEdge(new DirectedEdge(2, 7, 0.34)); G.addEdge(new DirectedEdge(6, 2, 0.40));
        G.addEdge(new DirectedEdge(3, 6, 0.52)); G.addEdge(new DirectedEdge(6, 0, 0.58));
        G.addEdge(new DirectedEdge(6, 4, 0.93));

        BellmanFordSP bmsp = new BellmanFordSP(G, 0);

        Assert.assertTrue(!bmsp.hasNegativeCycle());
        if (bmsp.hasPathTo(7)) {
            Stack stack = (Stack) bmsp.pathTo(7);
            Assert.assertTrue(stack.size() == 2);
            Stack stack1 = (Stack) bmsp.pathTo(1);
            Assert.assertTrue(stack1.size() == 7);

        }
    }
}
