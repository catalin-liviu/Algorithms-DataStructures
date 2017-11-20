package EdgeWeightedDigraph;


import MyDataStructures.Bag;

/**
 * Created by catalin.dinu on 11/7/2017.
 */

public class DirectedGraphAdjListRepresented {

    private int V;                  // number of vertices
    private int E;                  // number of edges
    private Bag<Integer>[] adj;     // array of bags, will hold adjacent vertices for every vertex in the graph

    /*
    * Constructor
    * */
    public DirectedGraphAdjListRepresented(int V) {
        this.V = V;
        E = 0;
        adj = new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }
    }


    /*
    * Adds one direction edge between two vertices
    * */
    public void addEdge(int v, int w){
        validateVertex(v);
        validateVertex(w);
        adj[v].add(w);
        E++;
    }


    public void addEdge(DirectedEdge edge) {
        int v = edge.from();
        int w = edge.to();
        validateVertex(v);
        validateVertex(w);
        adj[v].add(w);
        E++;
    }

    /*
    * Returns the number of vertices
    * */
    public int V(){
        return V;
    }

    /*
    * Returns the number of edges
    * */
    public int E(){
        return E;
    }

    /*
    * Returns the graph reversed
    * */
    public DirectedGraphAdjListRepresented reverse() {
        DirectedGraphAdjListRepresented reversed = new DirectedGraphAdjListRepresented(V);
        for (int v = 0; v < V; v++) {
            for (int w: adj(v)) {
                reversed.addEdge(w, v);
            }
        }
        return reversed;
    }


    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }

    /*
    * Checks if vertex is in a graph
    * */
    private void validateVertex(int v) {
        if (v < 0 || v >= V) {
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
        }
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
