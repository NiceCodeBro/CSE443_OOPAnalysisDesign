import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class GraphImplementation<T> implements Graph<T>, Serializable{
	private List<Edge<T>> edgeList;
    private List<Vertex<T>> vertexList;
    

    public GraphImplementation() {
        vertexList = new ArrayList<>();
        edgeList = new ArrayList<>();
    }

    @Override
    public Graph<T> addVertex(T val) {
        vertexList.add(new GraphVertex<>(val));

        return this;
    }



    @Override
    public Graph<T> addEdge(T val, T neighborVal, double edgeVal) {
        Vertex<T> source = getVertex(val);
        Vertex<T> neighbor = getVertex(neighborVal);

        edgeList.add(new GraphEdge<>(source, neighbor, edgeVal));

        return this;
    }



    public Vertex<T> getVertex(T val) {
        Iterator<Vertex<T>> iterVertex = vertexList.iterator();

        while (iterVertex.hasNext()) {
            Vertex<T> vertex = iterVertex.next();

            if (vertex.getVertexValue().equals(val)) {
                return vertex;
            }
        }

        return null;
    }

    public Edge<T> getEdge(T val, T neighborVal){
        Iterator<Edge<T>> iterEdge = edgeList.iterator();

        while (iterEdge.hasNext()) {
            Edge<T> edge = iterEdge.next();

            if (edge.getVertex().getVertexValue().equals(val) &&
                edge.getNeighborVertex().getVertexValue().equals(neighborVal)) {
                return edge;
            }
        }

        return null;
    }

    public List<Vertex<T>> getVertices() {
        return vertexList;
    }

    public List<Edge<T>> getEdges() { return edgeList; }


}
