import java.io.Serializable;

public class GraphVertex<T> implements Vertex<T>, Serializable{
    private T vertexVal;
    public GraphVertex(T val) {
        vertexVal = val;
    }
    public void setVertexValue(T val) {
        vertexVal = val;
    }
    public T getVertexValue() {
        return vertexVal;
    }
    public String toString() {
        return "" + vertexVal;
    }
}