
package graph;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<List<Integer> > createAdjacencyList(List<List<Integer> > edges,
                        int numVertices) {
        
        List<List<Integer> > adjList = new ArrayList<>();
                
        for (int i = 0; i < numVertices; i++) {
            adjList.add(new ArrayList<>());
        }                
        
        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        
        return adjList;
    }

    public static void main(String[] args) {        
        int numVertices = 4;
        List<List<Integer> > edges = new ArrayList<>();
        edges.add(List.of(0, 1));
        edges.add(List.of(0, 2));
        edges.add(List.of(1, 2));
        edges.add(List.of(2, 3));
        edges.add(List.of(3, 1));                
        
        List<List<Integer> > adjList = createAdjacencyList(edges, numVertices);
        
        for (int i = 0; i < numVertices; ++i) {
            System.out.print(i + " -> ");
            
            for (int j = 0; j < adjList.get(i).size(); ++j) {
                System.out.print(adjList.get(i).get(j)
                                 + " ");
            }
            System.out.println();
        }
        
    }
}
