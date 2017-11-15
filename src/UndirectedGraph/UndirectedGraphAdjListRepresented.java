package UndirectedGraph;


import MyDataStructures.Bag;

/**
 * Created by catalin.dinu on 11/2/2017.
 */

public class UndirectedGraphAdjListRepresented {

    private int V;                  // number of vertices
    private int E;
    private Bag<Integer>[] adj;

    public UndirectedGraphAdjListRepresented(int V) {
        this.V = V;
        E = 0;
        adj = new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }
    }

    // returns the number of vertices
    public int V(){
        return V;
    }

    // returns the number of edges
    public int E(){
        return E;
    }

    /*
    * Checks if a given vertex exists in the Graph
    * */
    private void validateVertex(int v) {
        if (v < 0 || v >= V) {
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
        }
    }

    /*
    * Adds an edge between two vertices
    * */
    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        adj[v].add(w);
        adj[w].add(v);
        E++;

    }

    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices, " + E + " edges \n");
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (int w : adj[v]) {
                s.append(w + " ");
            }
            s.append("\n");
        }
        return s.toString();

    }
}
