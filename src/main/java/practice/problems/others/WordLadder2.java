package practice.problems.others;

import java.util.*;

/**
 * Created by yashraj on 3/8/19.
 */
public class WordLadder2 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        if(!wordList.contains(endWord)) {
            return result;
        }
        Set<String> unvisited = new HashSet<>();
        unvisited.addAll(wordList);

        LinkedList<Node> queue = new LinkedList<>();
        Node begin = new Node(beginWord, 0, null);
        queue.offer(begin);

        int minLen = Integer.MAX_VALUE;

        while(!queue.isEmpty()) {
            Node n = queue.poll();

            if(result.size() > 0 && n.depth > minLen) {
                return result;
            }

            for(int i=0;i<n.word.length();i++) {
                char c = n.word.charAt(i);
                char[] array = n.word.toCharArray();
                for(char j ='a';j<='z';j++) {
                    if(j == c) {
                        continue;
                    }
                    array[i] = j;
                    String word = new String(array);

                    if(endWord.equals(word)) {
                        List<String> list = new ArrayList<>();
                        list.add(word);
                        Node p = n;
                        while(p != null) {
                            list.add(p.word);
                            p = p.prev;
                        }
                        Collections.reverse(list);
                        result.add(list);
                        if(n.depth <= minLen) {
                            minLen = n.depth;
                        } else {
                            return result;
                        }
                    }
                    if(unvisited.contains(word)) {
                        Node newWord = new Node(word, n.depth+1, n);
                        queue.add(newWord);
                        unvisited.remove(word);
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        WordLadder2 w = new WordLadder2();

        List<String> list = Arrays.asList("hot","dot","dog", "lot", "log","cog");
        System.out.println(w.findLadders("hit", "cog", list));

        List<String> list1 = Arrays.asList("hot","dot","dog","lot","log");
        System.out.println(w.findLadders("hit", "cog", list1));
    }

    class Node {
        String word;
        int depth;
        Node prev;

        public Node(String word, int depth, Node prev) {
            this.word = word;
            this.depth = depth;
            this.prev = prev;
        }
    }
}
