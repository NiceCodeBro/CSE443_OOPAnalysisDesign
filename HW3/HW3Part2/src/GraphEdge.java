import java.io.Serializable;

public class GraphEdge<T> implements Edge<T>, Serializable{
    private Vertex<T> neighborVertex;
    private double edgeVal;
    private Vertex<T> vertex;

    public GraphEdge(Vertex<T> vertex, Vertex<T> neighborVertex, double edgeVal) {
        this.vertex = vertex;
        this.neighborVertex = neighborVertex;
        this.edgeVal = edgeVal;
    }
    public void setVertex(Vertex<T> x) {
        vertex = x;
    }
    public void setNeighborVertex(Vertex<T> x) {
        neighborVertex = x;
    }
    public double getEdgeValue() {
        return edgeVal;
    }
    public void setEdgeVal(double val) {
        edgeVal = val;
    }
    public Vertex<T> getVertex() {
        return vertex;
    }
    public Vertex<T> getNeighborVertex() {
        return neighborVertex;
    }
}
