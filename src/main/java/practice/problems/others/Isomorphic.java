package practice.problems.others;

/**
 * Given two (dictionary) words as Strings, determine if they are isomorphic. Two words are called isomorphic
 * if the letters in one word can be remapped to get the second word. Remapping a letter means replacing all
 * occurrences of it with another letter while the ordering of the letters remains unchanged. No two letters
 * may map to the same letter, but a letter may map to itself.

 * Example:
 * given "foo", "app"; returns true
 * we can map 'f' -> 'a' and 'o' -> 'p'
 * given "bar", "foo"; returns false
 * we can't map both 'a' and 'r' to 'o'

 * given "turtle", "tletur"; returns true
 * we can map 't' -> 't', 'u' -> 'l', 'r' -> 'e', 'l' -> 'u', 'e' -'r'

 * given "ab", "ca"; returns true
 * we can map 'a' -> 'c', 'b'
 *
 * @author Yashraj R. Sontakke
 */
public class Isomorphic {

    public boolean isIsomorphic(String input1, String input2){
        if (input1.length() != input2.length()){
            return false;
        }
        char[] array = new char[255];
        for (int i=0;i<input1.length();i++){
            if (array[input1.charAt(i)] == 0){
                array[input1.charAt(i)] = input2.charAt(i);
            }else if (array[input1.charAt(i)]!=input2.charAt(i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Isomorphic i = new Isomorphic();
        System.out.println(i.isIsomorphic("foo","app"));
        System.out.println(i.isIsomorphic("turtle","tletur"));
        System.out.println(i.isIsomorphic("ab","ca"));
        System.out.println(i.isIsomorphic("foo","bar"));
    }
}
