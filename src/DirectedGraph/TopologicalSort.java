package DirectedGraph;


import MyDataStructures.LinkedList;
import MyDataStructures.Queue;

import java.util.List;

/**
 * Created by catalin.dinu on 11/9/2017.
 */

public class TopologicalSort {
    private boolean[] marked;
    private Queue<Integer> postOrder;


    public TopologicalSort(DirectedGraphAdjListRepresented G) {
        marked = new boolean[G.V()];
        postOrder = new Queue<>();
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                dfs(G, v);
            }
        }
    }

    public void dfs(DirectedGraphAdjListRepresented G, int v) {
        marked[v] = true;
        for (int w: G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);

            }
        }
        postOrder.offer(v);
    }

    public void display() {
        LinkedList<Integer> topologicalList = new LinkedList<>();
        for (int i: postOrder) {
            topologicalList.addFirst(i);
        }
        topologicalList.print();
    }

}
