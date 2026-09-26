
package myVersion;

import java.util.ArrayList;

public class Vertex {
    
    private String data;
    private ArrayList<Edge> edges;
    
    public Vertex(String data) {
        this.data = data;
        edges = new ArrayList<>();
    }

    public String getData() {
        return data;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    @Override
    public String toString() {
        return data;
    }
       
    public void addEdge(Vertex endV, Integer weight) {        
        edges.add(new Edge(this, endV, weight));        
    }
    
    public void removeEdge(Vertex endV) {
        edges.removeIf(edge -> edge.getEndV() == endV);
    }
    
    public void print(boolean isWeighted) {                
        String message = data + " -> ";
        
        for (int i = 0; i < edges.size(); i++) {
            
            message += edges.get(i).getEndV().data;
            
            if (isWeighted)
                message += " (" + edges.get(i).getWeight() + ")";
            
            if (i != edges.size() - 1)
                message += ", ";
            
        }
        System.out.println(message);        
    }
    
    
}
