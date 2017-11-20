package EdgeWeightedDigraph;

import DirectedGraph.EdgeWeightedDirectedGraph;

import java.util.Stack;

public class EdgeCycleFinder {
    private boolean[] marked;
    private boolean[] onStack;
    private DirectedEdge[] edgeTo;
    private Stack<DirectedEdge> cycle;

    public EdgeCycleFinder(EdgeWeightedDirectedGraph G) {
        marked = new boolean[G.V()];
        onStack = new boolean[G.V()];
        edgeTo = new DirectedEdge[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                dfs(G, v);
            }
        }
    }

    private void dfs(EdgeWeightedDirectedGraph G, int v) {
        onStack[v] = true;
        marked[v] = true;
        // go through every vertex adjacent to v
        for (DirectedEdge edge: G.adj(v)) {
            int w = edge.to();
            // if there is a cycle short circuit
            if (cycle != null) {
                return;
                /*
                * if adjacent vertex are unmarked ad v as the edgeTo and run dfs recursively
                * */
            } else if (!marked[w]) {
                edgeTo[w] = edge;
                dfs(G, w);
            } else if (onStack[w]) {
                cycle = new Stack<DirectedEdge>();
                DirectedEdge f = edge;
                while (f.from() != w) {
                    cycle.push(f);
                    f = edgeTo[f.from()];
                }
                cycle.push(f);
                return;
            }
        }
        onStack[v] = false;
    }


    /*
    * Checks if the graph has a cycle
    * */
    public boolean hasCycle() {
        return cycle != null;
    }

    /*
    * Returns a cycle if there is one / null otherwise
    * */
    public Iterable<DirectedEdge> cycle() {
        return cycle;
    }

}
