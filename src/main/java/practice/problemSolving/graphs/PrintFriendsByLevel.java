package practice.problemSolving.graphs;

import practice.dataStructures.graphs.Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Print the level of friendship.
 * <p/>
 * Given a person and list of his friends, print all his friends by level of association.
 * <p/>
 * The text file will be like one below
 * <p/>
 * A: B,C,D
 * D: B,E,F
 * E: C,F,G
 * <p/>
 * If the input is A, the out put should be:
 * <p/>
 * Level 1 - B,C,D
 * Level 2 - E,F
 * Level 3 - G
 *
 * @author Yashraj R. Sontakke
 */
public class PrintFriendsByLevel {

    public void printFriendsByLevel(Graph graph, String in) {
        if (!graph.getVertices().contains(in)) {
            return;
        }
        Queue<String> queue = new LinkedList<String>();
        Set<String> visited = new HashSet<String>();
        queue.add(in);
        visited.add(in);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String friend = queue.remove();
                if (!friend.equals(in)) {
                    System.out.print(friend + " ");
                }
                for (String s : graph.getNeighbors(friend)) {
                    if (!visited.contains(s)) {
                        queue.add(s);
                        visited.add(s);
                    }
                }

            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        PrintFriendsByLevel p = new PrintFriendsByLevel();
        Graph graph = new Graph();
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("A", "D");

        graph.addEdge("D", "B");
        graph.addEdge("D", "E");
        graph.addEdge("D", "F");

        graph.addEdge("E", "C");
        graph.addEdge("E", "F");
        graph.addEdge("E", "G");

        p.printFriendsByLevel(graph, "A");
    }
}
