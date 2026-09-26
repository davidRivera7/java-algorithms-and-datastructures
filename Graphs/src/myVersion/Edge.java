
package myVersion;

public class Edge {
    
    private Vertex startV;
    private Vertex endV;
    private Integer weight;
    
    public Edge(Vertex startV, Vertex endV, Integer weight) {
        this.startV = startV;
        this.endV = endV;
        this.weight = weight;
    }

    public Vertex getStartV() {
        return startV;
    }

    public Vertex getEndV() {
        return endV;
    }

    public Integer getWeight() {
        return weight;
    }        
    
}
