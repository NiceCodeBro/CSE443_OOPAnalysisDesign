import java.util.List;

public interface Graph<T> {
    public Vertex<T> getVertex(T val);
    public Graph<T> addVertex(T val);
    public Edge<T> getEdge(T val, T neighborVal);
    public List<Edge<T>> getEdges();
    public List<Vertex<T>> getVertices();
    public Graph<T> addEdge(T val, T neighborVal, double edgeVal);
}
