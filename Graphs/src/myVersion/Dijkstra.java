
package myVersion;

import java.util.ArrayList;

public class Dijkstra {
    
    public static void dijkstra(Vertex start, Vertex end,
            ArrayList<String> solution, ArrayList<String> test,
            ArrayList<Integer> sum, ArrayList<Integer> best,
            ArrayList<Vertex> origins) {
        
        if (start == end) {
            
            if (solution.isEmpty() || getSum(sum) < getSum(best)) {
                
                best.clear();                
                for (int i : sum) 
                    best.add(i);                
                
                solution.clear();                                
                for (String i : test) 
                    solution.add(i);                
            }
            
        } else {
                                    
            for (int i = 0; i < start.getEdges().size(); i++) {

                if (advance(origins, start.getEdges().get(i).getEndV())) { 
                    
                    origins.add(start);
                    
                    test.add(start.getData()
                            + " --> " + start.getEdges().get(i).getEndV().getData()
                            + " (" + start.getEdges().get(i).getWeight() + "), ");
                    
                    sum.add(start.getEdges().get(i).getWeight());

                    dijkstra(start.getEdges().get(i).getEndV(), end, 
                            solution, test, sum, best, origins);
                    
                    test.remove(test.size() - 1);
                    sum.remove(sum.size() - 1);
                    origins.remove(start);
                }
                
            }
            
        }
        
    }
    
    public static int getSum(ArrayList<Integer> sum) {
        int acum = 0;
        for (int i : sum) {
            acum += i;
        }
        return acum;
    }
    
    /**
     * para donde voy tiene que ser diferente de donde vengo
     * @param origins
     * @param destiny
     * @return 
     */
    public static boolean advance(ArrayList<Vertex> origins, Vertex destiny) {        
        for (Vertex i : origins) {
            if (i == destiny)
                return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        Graph graph = new Graph(false, true);
        
        Vertex A = graph.addVertex("A");
        Vertex B = graph.addVertex("B");
        Vertex C = graph.addVertex("C");
        Vertex D = graph.addVertex("D");
        Vertex E = graph.addVertex("E");
        Vertex F = graph.addVertex("F");        
        
        graph.addEdge(A, B, 4);
        graph.addEdge(A, C, 2);
        graph.addEdge(B, C, 1);
        graph.addEdge(B, D, 5);
        graph.addEdge(C, D, 8);
        graph.addEdge(C, E, 10);
        graph.addEdge(D, E, 2);
        graph.addEdge(D, F, 6);
        graph.addEdge(E, F, 2);                        
                       
        graph.print();   
        
        ArrayList<String> solution = new ArrayList<>();
        ArrayList<Integer> best = new ArrayList<>();
        
        dijkstra(A, F, solution, new ArrayList<>(), 
                new ArrayList<>(), best, new ArrayList<>());
        
        System.out.println("\nRuta mas corta:");
        for (String i : solution) {
            System.out.print(i);
        }
        System.out.println("\nPeso: " + getSum(best));
    }
    
}
