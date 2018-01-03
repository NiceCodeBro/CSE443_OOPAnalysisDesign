import java.io.Serializable;

public class IncidenceMatrix<T> implements Serializable{

    public String giveIncidenceMatrix(Graph<T> graph)
    {
        int IncMatrix[][];
        IncMatrix = new int[graph.getVertices().size()][graph.getVertices().size()];

        for(int k = 0 ; k < graph.getEdges().size(); ++k)
            for(int i = 0; i < graph.getVertices().size(); ++i)
            {
                for(int j = 0; j < graph.getVertices().size(); ++j)
                {
                    graph.getVertices().get(i).getVertexValue();
                    graph.getVertices().get(j).getVertexValue();

                    if(graph.getEdges().get(k).getVertex() == graph.getVertices().get(i) && graph.getEdges().get(k).getNeighborVertex() == graph.getVertices().get(j)  )
                    {
                        IncMatrix[i][j] = 1;
                    }
                }
            }


        String matris = "";
        for(int i = 0; i < graph.getVertices().size(); ++i)
        {
            for(int j = 0; j < graph.getVertices().size(); ++j)
            {
                matris += IncMatrix[i][j] + " ";
                //System.out.print(IncMatrix[i][j] + " ");
            }
            matris += "\n";
            //System.out.println();
        }



        return matris;
    }


}
