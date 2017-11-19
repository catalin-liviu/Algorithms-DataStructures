package DirectedGraph;


import EdgeWeightedDigraph.DirectedGraphAdjListRepresented;
import MyDataStructures.Queue;

import java.util.Stack;

/**
 * Created by catalin.dinu on 11/8/2017.
 */

public class BFS {
    // Member variables
    private boolean[] marked;       // will hold an evidence of the visited vertices
    private int[] edgeTo;
    private int[] distTo;


    public BFS(DirectedGraphAdjListRepresented G, int source) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        distTo = new int[G.V()];
        validateVertex(source);
        bfs(G, source);
    }

    private void bfs(DirectedGraphAdjListRepresented G, int s) {
        Queue<Integer> queue = new Queue<>();
        marked[s] = true;
        distTo[s] = 0;
        queue.offer(s);

        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int w: G.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    marked[w] = true;
                    queue.offer(w);

                }
            }
        }
    }

    public boolean hasPathTo(int v) {
        validateVertex(v);
        return marked[v];
    }

    public int distTo(int v) {
        validateVertex(v);
        return distTo[v];
    }

    public Iterable<Integer> pathTo(int v) {
        validateVertex(v);
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<Integer> path = new Stack<Integer>();
        int x;
        for (x = v; distTo[x] != 0  ; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(x);

        return path;
    }


    private void validateVertex(int v) {
        int V = marked.length;
        if (v < 0 || v >= V) {
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
        }
    }
}
