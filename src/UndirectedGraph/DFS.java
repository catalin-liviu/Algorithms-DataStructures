package UndirectedGraph;


import MyDataStructures.Stack;

/**
 * Created by catalin.dinu on 11/2/2017.
 */

public class DFS {

    private boolean[] marked;      // marked[v] = is there an s-v path?
    private int[] edgeTo;          // edgeTo[v] = last edge on s-v path
    private final int s;           // source vertex


    /*
    * Constructor
    * */
    public DFS(UndirectedGraphAdjListRepresented G, int s) {
        this.s = s;
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        dfs(G, s);
    }

    // recursive dfs method call
    private void dfs(UndirectedGraphAdjListRepresented G, int v) {
        marked[v] = true;
        for(int w : G.adj(v)){
            if(!marked[w]){
                dfs(G, w);
                edgeTo[w] = v;
            }
        }
    }


    /*
    * Check if there is a path to a given vertex
    * */
    public boolean hasPathTo(int v) {
        return marked[v] = true;
    }


    /*
    * Returns the path to a destination vertex
    * */
    public Iterable<Integer> pathTo(int v) {
        validateVertex(v);
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<Integer> path = new Stack<Integer>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);

        return path;
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


    /*
    * Getters & Setters
    * */
    public boolean[] getMarked() {
        return marked;
    }
    public void setMarked(boolean[] marked) {
        this.marked = marked;
    }
}
