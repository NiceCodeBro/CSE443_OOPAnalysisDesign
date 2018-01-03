public interface Edge<T> {
    public void setVertex(Vertex<T> vertex);
    public void setNeighborVertex(Vertex<T> vertex);
    public double getEdgeValue();
    public void setEdgeVal(double val);
    public Vertex<T> getVertex();
    public Vertex<T> getNeighborVertex();
}
