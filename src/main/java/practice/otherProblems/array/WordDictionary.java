package practice.otherProblems.array;

/**
 * Created by yashraj on 2/7/19.
 */
public class WordDictionary {
    LinkedHashMap<Integer, Character> map;

    /** Initialize your data structure here. */
    public WordDictionary() {
        map = new LinkedHashMap<>();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        map.put(word.length(), map.getOrDefault(word.length(), new ArrayList<>()).add(word));
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        List<String> list = map.get(word.length());
        if(list == null) {
            return false;
        }
        for(String base:list) {
            if(base.equals(word)) {
                return true;
            }
            int i=0;
            while(i<word.length()) {
                if(word.charAt(i) == base.charAt(i) || word.charAt(i) =='.') {
                    i++;
                } else {
                    break;
                }
            }
            return
        }
    }
}
