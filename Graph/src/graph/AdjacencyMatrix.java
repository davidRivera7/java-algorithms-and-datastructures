
package graph;
import java.util.ArrayList;
import java.util.Arrays;

public class AdjacencyMatrix {
    
    public static int[][] createAdjacencyMatrix(ArrayList<ArrayList<Integer> > graph,
        int numVertices) {
        
        int[][] adjMatrix = new int[numVertices][numVertices];
       
        for (int i = 0; i < numVertices; ++i) {
            for (int j = 0; j < numVertices; ++j) {
                if (graph.get(i).get(j) == 1) {
                    adjMatrix[i][j] = 1;
                    adjMatrix[j][i] = 1;
                }
            }
        }

        return adjMatrix;
    }

    public static void main(String[] args) {        
        ArrayList<ArrayList<Integer> > graph = new ArrayList<>();
        graph.add(new ArrayList<>(Arrays.asList(0, 1, 0, 0)));
        graph.add(new ArrayList<>(Arrays.asList(1, 0, 1, 0)));
        graph.add(new ArrayList<>(Arrays.asList(0, 1, 0, 1)));
        graph.add(new ArrayList<>(Arrays.asList(0, 0, 1, 0)));

        int numVertices = graph.size();
        
        int[][] adjMatrix = createAdjacencyMatrix(graph, numVertices);
        
        for (int i = 0; i < numVertices; ++i) {
            for (int j = 0; j < numVertices; ++j) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}