package UndirectedGraph;

/**
 * Created by catalin.dinu on 11/7/2017.
 */

public class CC {
    private boolean[] marked;     // marked[v] - keep track of the visited vertices along the path
                                // and returns true if a vertex v has been marked
    private int count;          // number of components
    private int[] id;           // id[v] - id of connected component containing v
    private int[] size;         // size[id] - number of vertices in a given component


    /*
    * Constructor
    * For every unmarked vertex in the graph will find all connected components
    * Every time will find another connected component will increment the count variable
    * */
    public CC(UndirectedGraphAdjListRepresented G){
        marked = new boolean[G.V()];
        id = new int[G.V()];
        size = new int[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                dfs(G, v);
                count++;
            }
        }
    }

    /*
    * Recursive call of dfs method
    * */
    private void dfs(UndirectedGraphAdjListRepresented G, int v) {
        marked[v] = true;
        id[v] = count;
        size[count]++;
        for (int w: G.adj(v)) {
            if(!marked[w]) {
                dfs(G, w);
            }
        }
    }


    /*
    * Returns true if two vertices are in the same connected component
    * */
    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    /*
    * Returns the id of the connected component containing vertex
    * */
    public int id(int v) {
        validateVertex(v);
        return id[v];
    }

    /*
    * Returns the number of vertices in a given connected component containing vertex v
    * */
    public int size(int v) {
        validateVertex(v);
        return size[id[v]];
    }

    /*
    * Returns the number of connected components in the graph
    * */
    public int count() {
        return count;
    }

    public void validateVertex(int v) {
        int V = marked.length;
        if (v < 0 || v >= V) {
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));

        }
    }

}
