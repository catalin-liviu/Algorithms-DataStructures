package UndirectedGraph;

import MyDataStructures.Queue;
import MyDataStructures.Stack;


/**
 * Created by acer on 11/6/2017.
 */

public class BFS {
    private boolean[] marked;             // keep track of visited vertices on a s-v path
    private int[] edgeTo;                 // keep track of the last edge on the s-v path
    private int[] distTo;                 // keep track of the shortest path from s to v
    private int steps;


    // Constructor
    public BFS(UndirectedGraphAdjListRepresented G, int s){
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        distTo = new int[G.V()];
        validateVertex(s);
        bfs(G, s);
    }


    private void bfs(UndirectedGraphAdjListRepresented G, int s) {
        Queue<Integer> queue = new Queue<Integer>();
        distTo[s] = 0;
        marked[s] = true;
        queue.offer(s);

        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int w: G.adj(v)) {
                if(!marked[w]) {
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    marked[w] = true;
                    queue.offer(w);
                }
            }
        }
    }

    /*
    * Check if there is a path to a given vertex
    * */
    public boolean hasPathTo(int v) {
        validateVertex(v);
        return marked[v];
    }

    /*
    * Returns the number of vertices to a given vertex
    * */
    public int distTo(int v) {
        validateVertex(v);
        return distTo[v];
    }

    /*
    * Returns the path to a destination vertex
    * */
    public Iterable<Integer> pathTo(int v) {
        validateVertex(v);
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int x;
        for (x = v; distTo[x] != 0 ; x = edgeTo[x]) {
            stack.push(x);
            steps++;
        }
        stack.push(x);
        return stack;
    }

    /*
        * Checks if a given vertex exits in the graph
        * */
    private void validateVertex(int v) {
        int V = marked.length;
        if (v < 0 || v >= V) {
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
        }
    }

    public int getSteps() {
        return steps;
    }
}
