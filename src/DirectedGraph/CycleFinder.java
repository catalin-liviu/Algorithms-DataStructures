package DirectedGraph;

import java.util.Stack;

/**
 * Created by catalin.dinu on 11/8/2017.
 */

public class CycleFinder {

    private boolean[] marked;
    private boolean[] onStack;
    private int[] edgeTo;
    private Stack<Integer> cycle;

    public CycleFinder(DirectedGraphAdjListRepresented G) {
        marked = new boolean[G.V()];
        onStack = new boolean[G.V()];
        edgeTo = new int[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v] && cycle == null) {
                dfs(G, v);
            }
        }
    }

    private void dfs(DirectedGraphAdjListRepresented G, int v) {
        onStack[v] = true;
        marked[v] = true;
        // go through every vertex adjacent to v
        for (int w: G.adj(v)) {
            // if there is a cycle short circuit
            if (cycle != null) {
                return;
                /*
                * if adjacent vertex are unmarked ad v as the edgeTo and run dfs recursively
                * */
            } else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            } else if (onStack[w]) {
                cycle = new Stack<Integer>();
                for (int x = v; x != w ; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
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
    public Iterable<Integer> cycle() {
        return cycle;
    }

}
