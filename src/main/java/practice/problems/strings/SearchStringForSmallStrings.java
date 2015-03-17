package practice.problems.strings;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Given a string s and an array of smaller strings T, design a method to search s for
 * each small string in T.
 *
 * @author Yashraj R. Sontakke
 */
public class SearchStringForSmallStrings {

    SuffixTreeNode root = new SuffixTreeNode();

    public SearchStringForSmallStrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            String suffix = s.substring(i);
            root.insert(suffix, i);
        }
    }

    public ArrayList<Integer> search(String s) {
        return root.search(s);
    }

    public class SuffixTreeNode {
        HashMap<Character, SuffixTreeNode> children = new HashMap<Character, SuffixTreeNode>();
        char value;
        ArrayList<Integer> indexes = new ArrayList<Integer>();


        public void insert(String s, int index) {
            indexes.add(index);
            if (s != null && s.length() > 0) {
                value = s.charAt(0);
                SuffixTreeNode child = null;
                if (children.containsKey(value)) {
                    child = children.get(value);
                } else {
                    child = new SuffixTreeNode();
                    children.put(value, child);
                }
                String reminder = s.substring(1);
                child.insert(reminder, index);
            }
        }

        public ArrayList<Integer> search(String s) {
            if (s == null || s.length() == 0) {
                return indexes;
            } else {
                char first = s.charAt(0);
                if (children.containsKey(first)) {
                    String reminder = s.substring(1);
                    return children.get(first).search(reminder);
                }
            }
            return null;
        }
    }
}
