
package myVersion;

import java.util.ArrayList;

public class Graph {
    private ArrayList<Vertex> vertices;
    private boolean isDirected;
    private boolean isWeighted;

    public Graph(boolean isDirected, boolean isWeighted) {
        this.vertices = new ArrayList<>();
        this.isDirected = isDirected;
        this.isWeighted = isWeighted;
    }

    public ArrayList<Vertex> getVertices() {
        return vertices;
    }        
    
    public Vertex addVertex(String data) {
        Vertex v = new Vertex(data);
        vertices.add(v);
        return v;
    }
    
    public void removeVertex(Vertex vertex) {
        vertices.remove(vertex);
    }
    
    public void removeVertex(String data) {
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i).getData().equals(data)) {
                vertices.remove(i);            
                break;
            }
        }
    }
    
    public void addEdge(Vertex v1, Vertex v2, Integer weight) {        
        v1.addEdge(v2, weight);        
        
        if (!isDirected) 
            v2.addEdge(v1, weight);        
    }
    
    public void removeEdge(Vertex v1, Vertex v2) {                    
        v1.removeEdge(v2);
                
        if (!isDirected) 
            v2.removeEdge(v1);                
    }
    
    public void print() {
        for (Vertex i : vertices) 
            i.print(isWeighted);        
    }
    
}
