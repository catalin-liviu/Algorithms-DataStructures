package DirectedGraph;

public class DirectedEdge {

    private final int v;
    private final int w;
    private final float weight;


    public DirectedEdge (int v, int w, float weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }


    /*
    * Returns the weight of the edge
    * */
    public double weight() {
        return weight;
    }

    /*
    * Returns the tail of the edge
    * */
    public int from() {
        return v;
    }

    /*
    * Returns the head of the edge
    * */
    public int to() {
        return w;
    }

    @Override
    public String toString() {
        return v + "->" + w + " " + String.format("%5.2f", weight);
    }
}
