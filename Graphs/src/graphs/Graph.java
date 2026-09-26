package graphs;

import java.util.ArrayList;

public class Graph {
    
    public void addEdge(ArrayList<ArrayList<Integer> > graph, int u, int v) {                
        graph.get(u).add(v);
        graph.get(v).add(u);                
    }
    
    public void eliminateEdge(ArrayList<ArrayList<Integer> > graph, int u, int v) {
        
        for (int i = 0; i < graph.get(u).size(); i++) {
            if (graph.get(u).get(i) == v) {
                graph.get(u).remove(i);
                break;
            }
        }
        
        for (int i = 0; i < graph.get(v).size(); i++) {
            if (graph.get(v).get(i) == u) {
                graph.get(v).remove(i);
                break;
            }
        }        
    }
    
    public void printGraph(ArrayList<ArrayList<Integer> > graph) {
        for (int i = 0; i < graph.size(); i++) {
            System.out.print("v " + i + " -> ");
            
            for (int j = 0; j < graph.get(i).size(); j++) {
                System.out.print(graph.get(i).get(j) + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    public void printData(ArrayList<ArrayList<Integer> > graph, Person[] persons) {
        for (int i = 0; i < graph.size(); i++) {
            System.out.print(persons[i] + " -> ");
            
            for (int j = 0; j < graph.get(i).size(); j++) {
                System.out.print(persons[graph.get(i).get(j)] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    public void searchConections(ArrayList<ArrayList<Integer> > graph, Person[] persons, int id) {
        
        System.out.print(persons[id] + " ->");
        for (int i = 0; i < graph.get(id).size(); i++)             
            System.out.print(persons[graph.get(id).get(i)] + " ");                    
        
        System.out.println("");
        
    }
            
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer> > graph = new ArrayList<>();
        
        for (int i = 0; i < 5; i++) {
            graph.add(new ArrayList<>());
        }                
        
        Person[] persons = {
            new Person(0, "David"),
            new Person(1, "Jessica"),
            new Person(2, "Selene"),
            new Person(3, "Alison"),
            new Person(4, "Eduardo"),
        };
        
        Graph g = new Graph();        
        
        g.addEdge(graph, 0, 1);//David -> Jessica
        g.addEdge(graph, 0, 2);//David -> Selene
        
        g.addEdge(graph, 1, 4);//Jessica -> Eduardo
        
        g.addEdge(graph, 4, 0);//Eduardo -> David
                        
        g.printGraph(graph);  
        g.printData(graph, persons);
        
        g.searchConections(graph, persons, 0);
    }
    
}
