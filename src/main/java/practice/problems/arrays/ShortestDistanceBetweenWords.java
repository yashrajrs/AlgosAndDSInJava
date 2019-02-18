package practice.problems.arrays;

/**
 * You have a large text file containing words. Given any two words, find the shortest
 * distance (in terms of number of words) between them in the file.
 *
 * @author Yashraj R. Sontakke
 */
public class ShortestDistanceBetweenWords {
    public int getDistance(String[] words, String word1, String word2){
        int word1Location = -1;
        int word2Location = -1;
        int min = Integer.MAX_VALUE;

        for (int i=0;i<words.length;i++){
            String currentWord = words[i];
            if (word1.equals(currentWord)){
                word1Location = i;
                int distance = Math.abs(word1Location - word2Location);
                if (word2Location >=0 && min > distance){
                    min = distance;
                }
            }else if (word2.equals(currentWord)){
                word2Location = i;
                int distance = Math.abs(word1Location - word2Location);
                if (word1Location > 0 && min > distance){
                    min = distance;
                }
            }
        }
        return min;
    }

    public int shortestDistance(String[] words, String word1, String word2) {
        int m=-1;
        int n=-1;
        int min = Integer.MAX_VALUE;

        for (int i=0;i<words.length;i++) {
            String word = words[i];
            if (word.equals(word1)) {
                m = i;
                if (n!=-1) {
                    min = Math.min(min, m-n);
                }
            } else if (word.equals(word2)) {
                n = i;
                if (m!=-1) {
                    min = Math.min(min, n-m);
                }
            }
        }
        return min;
    }

    public static void main(String[] args){
        ShortestDistanceBetweenWords shortestDistanceBetweenWords = new ShortestDistanceBetweenWords();
        String[] words ={"AB", "BC", "CD","DE","EF","ABC", "BCD","DEF"};
        System.out.println(shortestDistanceBetweenWords.getDistance(words, "CD", "BCD"));
    }
}
