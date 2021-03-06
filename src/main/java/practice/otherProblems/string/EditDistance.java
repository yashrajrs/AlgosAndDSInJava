package practice.otherProblems.string;

/**
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
 * <p/>
 * You have the following 3 operations permitted on a word:
 * <p/>
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 *
 * @author Yashraj R. Sontakke
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= len2; i++) {
            dp[0][i] = i;
        }

        for (int i = 0; i < len1; i++) {
            char c1 = word1.charAt(i);
            for (int j = 0; j < len2; j++) {
                char c2 = word2.charAt(j);
                if (c1 == c2) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    int replace = dp[i][j] + 1;
                    int insert = dp[i][j + 1] + 1;
                    int delete = dp[i + 1][j] + 1;
                    int min = Math.min(replace, Math.min(insert, delete));
                    dp[i + 1][j + 1] = min;
                }
            }
        }
        return dp[len1][len2];

    }

    public static void main(String[] args){
        EditDistance e = new EditDistance();
        System.out.println(e.minDistance("abc", "def"));
        System.out.println(e.minDistance("horse", "ros"));
        System.out.println(e.minDistance("intention", "execution"));
    }
}
