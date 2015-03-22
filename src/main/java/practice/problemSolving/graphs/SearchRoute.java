package practice.problemSolving.graphs;

import practice.dataStructures.graphs.Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


/**
 * Given a directed graph, design an algorithm to find out whether there is a route
 * between two nodes.
 *
 * @author Yashraj R. Sontakke
 */
public class SearchRoute {

    public boolean isRoute(Graph graph, String node1, String node2) {
        if (!graph.getVertices().contains(node1)) {
            return false;
        }
        Queue<String> queue = new LinkedList<String>();
        Set<String> visited = new HashSet<String>();

        queue.add(node1);
        visited.add(node1);
        while (!queue.isEmpty()) {
            String vertex = queue.remove();
            for (String edge : graph.getNeighbors(vertex)) {
                if (edge.equals(node2)) {
                    return true;
                }
                if (!visited.contains(edge)) {
                    visited.add(edge);
                    queue.add(edge);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Graph graphInput = new Graph();
        graphInput.addEdge("A", "B");
        graphInput.addEdge("A", "C");

        graphInput.addEdge("B", "D");
        graphInput.addEdge("C", "E");

        SearchRoute searchRoute = new SearchRoute();
        System.out.println(searchRoute.isRoute(graphInput, "A", "D"));
        System.out.println(searchRoute.isRoute(graphInput, "C", "D"));

    }
}
