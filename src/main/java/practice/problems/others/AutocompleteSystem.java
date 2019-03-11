package practice.problems.others;

import java.util.*;

/**
 * Created by yashraj on 3/7/19.
 */
public class AutocompleteSystem {
    TrieNode root;
    String prefix;

    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        prefix = "";
        for (int i=0;i<sentences.length;i++) {
            add(sentences[i], times[i]);
        }
    }

    public void add(String s, int count) {
        TrieNode cur = root;
        for (char c: s.toCharArray()) {
            TrieNode next = cur.children.get(c);
            if (next == null) {
                next = new TrieNode();
                cur.children.put(c, next);
            }
            cur = next;
            cur.counts.put(s, cur.counts.getOrDefault(s, 0) + count);
        }
        cur.isWord = true;
    }

    public List<String> input(char c) {
        if (c == '#') {
            add(prefix, 1);
            prefix = "";
            return new ArrayList<>();
        }

        prefix = prefix + c;
        TrieNode cur = root;

        for (char cc: prefix.toCharArray()) {
            TrieNode next = cur.children.get(cc);
            if (next == null) {
                return new ArrayList<>();
            }
            cur = next;
        }
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>(
                (a,b) -> (a.c == b.c ? a.s.compareTo(b.s) : b.c - a.c));
        for (String s: cur.counts.keySet()) {
            priorityQueue.add(new Pair(s, cur.counts.get(s)));
        }
        List<String> result = new ArrayList<>();
        for (int i=0;i<3 && !priorityQueue.isEmpty() ;i++) {
            result.add(priorityQueue.poll().s);
        }
        return result;
    }

    public static void main(String[] args) {
        String[] sentences = {"i love you", "island","ironman", "i love leetcode"};
        int[] times = {5, 3, 2, 2};
        AutocompleteSystem a = new AutocompleteSystem(sentences, times);
        System.out.println(a.input('i')); // "i love you", "island","i love leetcode"
        System.out.println(a.input(' ')); // "i love you","i love leetcode"
        System.out.println(a.input('a')); // []
        System.out.println(a.input('#')); // []
    }








    class TrieNode {
        Map<Character, TrieNode> children;
        Map<String, Integer> counts;
        boolean isWord;

        public TrieNode() {
            children = new HashMap<>();
            counts = new HashMap<>();
            isWord = false;
        }
    }

    class Pair {
        String s;
        int c;

        public Pair(String s, int c) {
            this.s = s;
            this.c = c;
        }
    }
}
