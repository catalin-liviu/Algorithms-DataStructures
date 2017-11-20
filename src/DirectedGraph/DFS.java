package DirectedGraph;

import EdgeWeightedDigraph.DirectedGraphAdjListRepresented;
import MyDataStructures.Stack;


/**
 * Created by catalin.dinu on 11/8/2017.
 */

public class DFS {

    private boolean[] marked;       // marked[v] - return true if v is reachable from a given source vertex
    private int count;              // number of vertices from source to v
    private int s;                  // source vertex
    private int[] edgeTo;


    public DFS(DirectedGraphAdjListRepresented G, int source) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        s= source;
        dfs(G, source);
    }

    private void dfs(DirectedGraphAdjListRepresented G, int v) {
        count++;
        marked[v] = true;
        for (int w: G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }

    /*
    * Returns the path to a destination vertex
    * */
    public Iterable<Integer> pathTo(int v) {
        validateVertex(v);
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<Integer> stack = new Stack<>();
        int x;
        for (x = v; x != s ; x = edgeTo[x]) {
            stack.push(x);
        }
        stack.push(x);
        return stack;
    }

    /*
     * Check if there is a path to a given vertex
     * */
    public boolean hasPathTo(int v){
        validateVertex(v);
        return marked[v];
    }

    /*
    * Returns the number of vertices from source to destination
    * */
    public int count() {
        return count;
    }

    private void validateVertex(int v) {
        int V = marked.length;
        if (v < 0 || v >= V) {
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
        }
    }
}
