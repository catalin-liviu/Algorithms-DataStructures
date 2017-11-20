package EdgeWeightedDigraph;

import DirectedGraph.EdgeWeightedDirectedGraph;
import MyDataStructures.Queue;
import MyDataStructures.Stack;

/**
* This class will find the shortest path in a directed, non-negative cycles
 * Alternatively it can find a negative cycle in a graph if there is one
* */

public class BellmanFordSP {

    private int N;
    private double[] distTo;               // distance  of shortest path form s to v
    private DirectedEdge[] edgeTo;         // last edge on shortest path from s to v
    private boolean[] onQueue;             // onQueue[v] = is v currently on the queue?
    private Queue<Integer> queue;          // queue of vertices to relax
    private int cost;                      // number of calls to relax()
    private Iterable<DirectedEdge> cycle;  // negative cycle (or null if no such cycle)


    public BellmanFordSP(EdgeWeightedDirectedGraph G, int source) {
        N = G.V();
        distTo = new double[G.V()];
        edgeTo = new DirectedEdge[G.V()];
        onQueue = new boolean[G.V()];

//        Set the distance to source to 0
        distTo[source] = 0.0;
//        Set the distance to all other vertices from the graph to infinite
        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }

        // Bellman-Ford algorithm
        queue = new Queue<Integer>();
        queue.offer(source);
        onQueue[source] = true;

        while (!queue.isEmpty() && !hasNegativeCycle()) {
            int v = queue.poll();
            onQueue[v] = false;
            relax(G, v);
        }

    }

    /*
    * Relaxation function
    * Relax every vertex adjacent to the source
    * */
    private void relax(EdgeWeightedDirectedGraph G, int v) {
        for (DirectedEdge edge: G.adj(v)) {
            int w = edge.to();
            if (distTo[w] > distTo[v] + edge.weight()) {
                distTo[w] = distTo[v] + edge.weight();
                edgeTo[w] = edge;

                if (!onQueue[w]) {
                    queue.offer(w);
                    onQueue[w] = true;
                }
            }
            if (cost++ % G.V() == 0) {
                findNegativeCycle();
                if (hasNegativeCycle()) {
                    return;
                }
            }
        }
    }

    private void findNegativeCycle() {
        EdgeWeightedDirectedGraph graph = new EdgeWeightedDirectedGraph(N);
        for (int v = 0; v < N; v++) {
            if (edgeTo[v] != null) {
                graph.addEdge(edgeTo[v]);
            }
        }
        EdgeCycleFinder edgeCycleFinder = new EdgeCycleFinder(graph);
        cycle = edgeCycleFinder.cycle();
    }

    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    public Iterable<DirectedEdge> pathTo(int v) {
        validateVertex(v);
        if (hasNegativeCycle())
            throw new UnsupportedOperationException("Negative cost cycle exists");
        if (!hasPathTo(v)) return null;
        Stack<DirectedEdge> path = new Stack<DirectedEdge>();
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
            path.push(e);
        }
        return path;
    }

    private void validateVertex(int v) {
        if (v < 0 || v >= N)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (N-1));
    }

    public boolean hasNegativeCycle() {
        return cycle != null;
    }

    public Iterable<DirectedEdge> showNegativeCycle() {
        return cycle;
    }

}
