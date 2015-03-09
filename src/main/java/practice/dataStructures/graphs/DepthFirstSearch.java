package practice.dataStructures.graphs;

import com.google.common.collect.Sets;

import java.util.Set;

/**
 * Implements depth first search
 *
 * @author Yashraj R. Sontakke
 */
public class DepthFirstSearch {

    public Graph graph;
    public Set<String> visited;

    public DepthFirstSearch(Graph graph) {
        this.graph = graph;
        this.visited = Sets.newHashSet();
    }

    public void dfs(String startingVertex) {
        if (!graph.getVertices().contains(startingVertex)) {
            return;
        }

        System.out.print(startingVertex + "\t");
        visited.add(startingVertex);
        for (String vertex : graph.getNeighbors(startingVertex)) {
            if (!visited.contains(vertex)) {
                dfs(vertex);
            }
        }
    }

    public static void main(String[] args) {
        Graph graphInput = new Graph();
        graphInput.addEdge("A", "B");
        graphInput.addEdge("A", "C");
        graphInput.addEdge("A", "D");

        graphInput.addEdge("B", "A");
        graphInput.addEdge("B", "D");

        graphInput.addEdge("C", "A");
        graphInput.addEdge("C", "D");

        graphInput.addEdge("D", "A");
        graphInput.addEdge("D", "B");
        graphInput.addEdge("D", "C");
        graphInput.addEdge("D", "E");

        graphInput.addEdge("E", "D");
        graphInput.addEdge("E", "G");
        graphInput.addEdge("E", "F");

        graphInput.addEdge("G", "E");
        graphInput.addEdge("G", "F");

        graphInput.addEdge("F", "E");
        graphInput.addEdge("F", "G");

        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(graphInput);
        depthFirstSearch.dfs("A");
        depthFirstSearch.visited = Sets.newHashSet();
        System.out.println();
        depthFirstSearch.dfs("F");
    }
}
