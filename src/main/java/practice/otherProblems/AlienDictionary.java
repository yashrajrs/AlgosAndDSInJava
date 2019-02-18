package practice.otherProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.

 Example 1:

 Input:
 [
 "wrt",
 "wrf",
 "er",
 "ett",
 "rftt"
 ]

 Output: "wertf"
 Example 2:

 Input:
 [
 "z",
 "x"
 ]

 Output: "zx"
 Example 3:

 Input:
 [
 "z",
 "x",
 "z"
 ]

 Output: ""

 Explanation: The order is invalid, so return "".
 Note:

 You may assume all letters are in lowercase.
 You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
 If the order is invalid, return an empty string.
 There may be multiple valid order of letters, return any one of them is fine.
 */
public class AlienDictionary {
    private final Integer NOT_VISITED = 0;
    private final Integer VISITING = 1;
    private final Integer VISITED = 2;

    public String alienOrder(String[] words) {
        if (words.length == 0) {
            return "";
        }
        if (words.length == 1) {
            return words[0];
        }
        HashMap<Character, ArrayList<Character>> graph = new HashMap<>();
        HashMap<Character, Integer> state = new HashMap<>();
        buildGraph(words, graph, state);

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char rootChar: state.keySet()) {
            stack.push(rootChar);
            while (!stack.isEmpty()) {
                char c = stack.pop();
                if (state.get(c) == VISITED) {
                    continue;
                }
                state.put(c, VISITING);
                if (graph.containsKey(c) && graph.get(c).size() !=0) {
                    char next = graph.get(c).remove(0);
                    if (state.get(next) == VISITING) {
                        return "";
                    }
                    stack.push(c);
                    stack.push(next);
                } else {
                    sb.insert(0, c);
                    state.put(c, VISITED);
                }
            }
        }
        return sb.toString();
    }

    public void buildGraph(String[] words, HashMap<Character, ArrayList<Character>> graph, HashMap<Character, Integer> state) {
        for (int i=1;i<words.length;i++) {
            char[] s1 = words[i-1].toCharArray();
            char[] s2 = words[i].toCharArray();

            if (s1.length == 0) {
                continue;
            }
            int minLen = Math.min(s1.length, s2.length);
            int maxLen = Math.max(s1.length, s2.length);

            boolean dependencyFound = false;
            for (int j=0;j<maxLen;j++) {
                if (j<s1.length) {
                    state.put(s1[j], NOT_VISITED);
                }
                if (j<s2.length) {
                    state.put(s2[j], NOT_VISITED);
                }
                if (j<minLen && !dependencyFound && s1[j] != s2[j]) {
                    graph.putIfAbsent(s1[j], new ArrayList<>());
                    graph.get(s1[j]).add(s2[j]);
                    dependencyFound = true;
                }

            }
            dependencyFound = false;
        }
    }

    public static void main(String[] args) {
        AlienDictionary a = new AlienDictionary();
        String[] words1 = {"wrt",
                "wrf",
                "er",
                "ett",
                "rftt"};
        String[] words2 = {"z",
                "x"};
        String[] words3 = {"z",
                "x",
                "z"};
        System.out.println(a.alienOrder(words1));
        System.out.println(a.alienOrder(words2));
        System.out.println(a.alienOrder(words3));


    }



}
