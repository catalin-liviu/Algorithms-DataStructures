package DirectedGraph;

import MyDataStructures.Bag;

public class EdgeWeightedDirectedGraph {

    private final int V;
    private int E;
    private int[] indegree;
    private Bag<DirectedEdge>[] adj;


    public EdgeWeightedDirectedGraph(int V) {
        this.V = V;
        E = 0;
        indegree = new int[V];
        adj = new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<DirectedEdge>();
        }
    }

    // returns the number of vertices
    public int V() {
        return V;
    }
    // returns the number of edges
    public int E() {
        return E;
    }

    public void addEdge(DirectedEdge edge) {
        int v = edge.from();
        int w = edge.to();
        validateVertex(v);
        validateVertex(w);
        adj[v].add(edge);
        indegree[w]++;
        E++;
    }


    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }

    /*
    * Returns a iterable collection of all the edges
    * */
    public Iterable<DirectedEdge> edges() {
        Bag<DirectedEdge> bag = new Bag<DirectedEdge>();
        for (int v = 0; v < V; v++) {
            for (DirectedEdge edge: adj[v]) {
                bag.add(edge);
            }
        }
        return bag;
    }

    /*
    * Returns the number of edges to v
    * */
    public int indegree(int v) {
        return indegree[v];
    }

    /*
    * Returns the number of edges from v
    * */
    public int outdegree(int v) {
        return adj[v].size();
    }


    private void validateVertex(int v) {
        if (v < 0 || v >= V) {
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " " + E + "\n");
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (DirectedEdge e : adj[v]) {
                s.append(e + "  ");
            }
            s.append("\n");
        }
        return s.toString();
    }
}
