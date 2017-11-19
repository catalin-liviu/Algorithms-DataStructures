package EdgeWeightedDigraph;

import java.util.Comparator;

public class Vertex implements Comparator<Vertex> {

    private DirectedEdge edge;
    private double distTo;

    public Vertex() {
        distTo = edge.weight();

    }



    @Override
    public int compare(Vertex v, Vertex w) {
        if (((Double) v.distTo).compareTo(w.distTo) < 0) {
            return -1;
        } else if (((Double) v.distTo).compareTo(w.distTo) > 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
