package practice.otherProblems;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
 * return the length of last word in the string.

 * If the last word does not exist, return 0.

 * Note: A word is defined as a character sequence consists of non-space characters only.

 * For example,
 * Given s = "Hello World",
 * return 5.
 *
 * @author Yashraj R. Sontakke
 */
public class StringLengthOfLastWord {

    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0 || s.trim().length() == 0){
            return 0;
        }
        s = s.trim();
        String[] split = s.split(" ");
        if(split.length == 1){
            return s.length();
        }
        return split[split.length-1].length();

    }

    public static void  main(String[] args){
        StringLengthOfLastWord s = new StringLengthOfLastWord();
        System.out.println(s.lengthOfLastWord(""));
        System.out.println(s.lengthOfLastWord("  "));
        System.out.println(s.lengthOfLastWord(" A"));
        System.out.println(s.lengthOfLastWord(" A "));
        System.out.println(s.lengthOfLastWord("A "));
        System.out.println(s.lengthOfLastWord("A"));
        System.out.println(s.lengthOfLastWord("Hello World"));
    }
}
