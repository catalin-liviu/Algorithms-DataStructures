package EdgeWeightedDigraph;

import DirectedGraph.EdgeWeightedDirectedGraph;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class DijkstrasSP {

    private DirectedEdge[] edgeTo;
    private double[] distTo;
    private MinPQ<Double> pq;

    public DijkstrasSP(EdgeWeightedDirectedGraph G, int source) {
        // initialize member variable
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];
        pq = new MinPQ<Double>(G.V());

        // set the distTo value for all the vertices in the graph to positive infinite
        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        // set the distTo source value to 0.0, the only distTo known at the moment
        distTo[source] = 0.0;

        // put the source in the queue
        pq.insert(source, distTo[source]);

        while (!pq.isEmpty()) {
            int v = pq.delMin();
            // MinPQ Implementation: int v = pq.delMin();
            for (DirectedEdge edge: G.adj(v)) {
                relax(edge);
            }
        }
    }

    private void relax(DirectedEdge edge) {
        int v = edge.from(), w = edge.to();
        if (distTo[w] > distTo[v] + edge.weight()) {
            distTo[w] = distTo[v] + edge.weight();
            edgeTo[w] = edge;

            if (pq.contains(w)) {
                // if w is already in the queue, update it's key
                pq.decreaseKey(w, distTo[w]);
            } else { // if there isn't insert it in queue
                pq.insert(w, distTo[w]);
            }
        }
    }


    /*
    * Returns true if there is a path from the source vertex to a given vertex
    */
    public boolean hasPathTo(int v) {
        validateVertex(v);
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    /*
    * Returns the length of a shortest path from the source vertex to a given vertex
    */
    public double distTo(int v) {
        validateVertex(v);
        return distTo[v];
    }

    /*
     * Returns the shortest path from the source vertex to vertex to a given vertex
     */
    public Iterable<DirectedEdge> pathTo(int v) {
        validateVertex(v);
        Stack<DirectedEdge> path = new Stack<>();
        for (DirectedEdge edge = edgeTo[v]; edge != null; edge = edgeTo[edge.from()]) {
            path.push(edge);
        }
        return path;
    }


    private void validateVertex(int v) {
        int V = distTo.length;
        if (v < 0 || v >= V) {
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
        }
    }
}
