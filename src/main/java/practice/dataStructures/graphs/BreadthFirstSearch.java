package practice.dataStructures.graphs;

import com.google.common.collect.Sets;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Implements breadth first search
 *
 * @author Yashraj R. Sontakke
 */
public class BreadthFirstSearch {
    public Graph graph;
    public Set<String> visited;
    public Queue<String> queue;

    public BreadthFirstSearch(Graph graph) {
        this.graph = graph;
        this.visited = Sets.newHashSet();
        this.queue = new LinkedList<String>();
    }

    public void bfs(String startingVertex) {
        if (!graph.getVertices().contains(startingVertex)) {
            return;
        }
        visited = Sets.newHashSet();
        queue = new LinkedList<String>();

        queue.add(startingVertex);
        visited.add(startingVertex);
        while (!queue.isEmpty()) {
            String vertex = queue.remove();
            System.out.print(vertex + "\t");

            for (String adjacentNode : graph.getNeighbors(vertex)) {
                if (!visited.contains(adjacentNode)) {
                    queue.add(adjacentNode);
                    visited.add(adjacentNode);

                }
            }

        }
        System.out.println();

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

        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch(graphInput);
        breadthFirstSearch.bfs("A");
        breadthFirstSearch.bfs("F");
    }
}
