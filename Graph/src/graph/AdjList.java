
package graph;

import java.util.ArrayList;

class AdjNode {
    int vertex;
    AdjNode next;

    public AdjNode(int data) {
        vertex = data;
        next = null;
    }

    @Override
    public String toString() {
        return vertex + "";
    }        
}

class AdjList {
    private int v;
    private AdjNode[] graph;

    public AdjList(int vertices) {
        v = vertices;
        graph = new AdjNode[v];
        for (int i = 0; i < v; ++i) {
            graph[i] = null;
        }
    }

    // Function to add an edge from a source vertex
    // to a destination vertex
    public void addEdge(int source, int destination) {
        AdjNode node = new AdjNode(destination);
        node.next = graph[source];
        graph[source] = node;
    }

    // Function to add a vertex between two vertices
    public void addVertex(int vk, int source, int destination) {
        addEdge(source, vk);
        addEdge(vk, destination);
    }

    // Function to print the graph
    public void printGraph() {
        for (int i = 0; i < v; ++i) {
            System.out.print(i + " ");
            AdjNode temp = graph[i];
            while (temp != null) {
                System.out.print("-> " + temp.vertex + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }
    
    public AdjNode[] getGraph() {
        return graph;
    }        
    
    /**
     * Encuentra los caminos posibles para llegar desde un vertice a un destino en especial
     * @param destination
     * @param travel
     * @param origin 
     */
    public void paths(int destination, ArrayList<String> travel, int origin) {
        
        if (origin == destination) {                        
            
            travel.add(origin + "");
            for (String route : travel) {
                System.out.print(route + " -> ");
            }
            System.out.println("");
            
        } else {

            travel.add(origin + "");

            AdjNode temp = graph[origin];

            while (temp != null) {
                paths(destination, travel, temp.vertex);
                travel.remove(travel.size() - 1);
                temp = temp.next;
            }
        }
                
    }        
    
    public static void main(String[] args) {
        int V = 6;
        AdjList graph = new AdjList(V);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(3, 2);
        graph.addEdge(4, 3);

//        System.out.println("Initial adjacency list");
//        graph.printGraph();                
        
        // Add vertex
        graph.addVertex(5, 3, 2);
//        System.out.println("Adjacency list after adding vertex");
        graph.printGraph();
//                
        System.out.println("");
        graph.paths(2, new ArrayList<>(), 0);                                                
    }
    
}


