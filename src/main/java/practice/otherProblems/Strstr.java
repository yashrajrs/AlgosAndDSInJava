package practice.otherProblems;

/**
 * Created with IntelliJ IDEA.
 * User: yashrajsontakke
 * Date: 4/4/15
 * Time: 10:55 PM
 * To change this template use File | Settings | File Templates.
 *
 * @author Yashraj R. Sontakke
 */
public class Strstr {

    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length()) {
            return -1;
        }
        if (needle.length() == 0 || (haystack.length() == needle.length() && haystack.equals(needle))) {
            return 0;
        }
        int needleLength = needle.length();
        int haystackLength = haystack.length();
        for (int i = 0; i < haystack.length(); i++) {
            if (haystackLength - i + 1 < needleLength) {
                return -1;
            }
            int k = i;
            int j = 0;
            while (j < needleLength && k < haystackLength && needle.charAt(j) == haystack.charAt(k)) {
                j++;
                k++;
                if (j == needleLength) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String a = "mississippi";
        String b = "pi";

        Strstr s = new Strstr();
        System.out.println(s.strStr(a, b));
        System.out.println(s.strStr("mississippi", "issipi"));
    }
}
