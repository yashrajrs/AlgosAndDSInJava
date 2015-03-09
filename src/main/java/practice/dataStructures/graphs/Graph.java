package practice.dataStructures.graphs;

import com.google.common.collect.HashMultimap;

import java.util.Set;

/**
 * Implements graph
 *
 * @author Yashraj R. Sontakke
 */
public class Graph {
    private HashMultimap<String, String> edges;

    public Graph() {
        this.edges = HashMultimap.create();
    }

    public void addEdge(String source, String destination) {
        if (edges == null) {
            edges = HashMultimap.create();
        }
        edges.put(source, destination);
    }

    public Set<String> getNeighbors(String source) {
        return edges.get(source);
    }

    public Set<String> getVertices(){
        return edges.keySet();
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("A", "D");

        graph.addEdge("B", "A");
        graph.addEdge("B", "C");

        graph.addEdge("C", "A");
        graph.addEdge("C", "B");
        graph.addEdge("D", "A");

        System.out.println(graph.getNeighbors("A").toString());
        System.out.println(graph.getNeighbors("B").toString());
        System.out.println(graph.getNeighbors("C").toString());
        System.out.println(graph.getNeighbors("D").toString());
        System.out.println(graph.getNeighbors("E").toString());
    }
}
