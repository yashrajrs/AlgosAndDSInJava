package practice.otherProblems.strings;

import java.util.*;

/**
 * Created by yashraj on 11/7/18.
 */
public class RandomSentenceGenerator {

    public class Node {
        String value;
        int probability;
        List<Node> children;

        public Node(String value) {
            this.value = value;
            probability = 0;
            children = new ArrayList<>();
        }
    }
    Map<String, Node> hashMap = new HashMap<>();
    String originalSentence;

    public void populate(String input) {
        originalSentence = input;
        String[] words = input.split(" ");
        String prev = words[0];
        populateParent(prev);
        for (int i=1;i<words.length;i++) {
            populateChild(prev, words[i]);
            if (!hashMap.containsKey(words[i])) {
                populateParent(words[i]);
            }
            prev = words[i];
        }
        System.out.println(hashMap.size());
    }

    public void populateChild(String parent, String child) {
        Node childNode = new Node(child);
        childNode.probability = 1;
        if (hashMap.containsKey(parent)) {
            Node parentNode = hashMap.get(parent);
            Node searchNode = null;
            for (Node childSearchNode: parentNode.children) {
                if (childSearchNode.value.equals(child)) {
                    searchNode = childSearchNode;
                }
            }
            if (searchNode != null) {
                searchNode.probability +=1;
            } else {
                parentNode.children.add(childNode);
            }
            parentNode.probability += 1;
        } else {
            Node parentNode = new Node(parent);
            parentNode.children.add(childNode);
        }
    }

    public void populateParent(String parent) {
        Node parentNode = new Node(parent);
        hashMap.put(parent, parentNode);
    }

    public String getSentence(int numberOfWords) {
        Random random = new Random();
        int randomNumber = random.nextInt(hashMap.size());
        String[] words = originalSentence.split(" ");
        String currentWord =words[randomNumber];

        String result = currentWord;
        int currentSize = 1;
        while ( currentSize < numberOfWords) {
            Node node = hashMap.get(currentWord);
            int childRandom = random.nextInt(node.probability);
            for (Node childNode: node.children) {
                if (childNode.probability > childRandom) {
                    result = result + " " + childNode.value;
                    currentWord = childNode.value;
                    currentSize++;
                    break;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        RandomSentenceGenerator randomSentenceGenerator = new RandomSentenceGenerator();
        String sentence = "There is a boy. There is a girl. There are companies. Companies are in a city.";
        randomSentenceGenerator.populate(sentence);

        System.out.println(randomSentenceGenerator.getSentence(3));
    }
}
