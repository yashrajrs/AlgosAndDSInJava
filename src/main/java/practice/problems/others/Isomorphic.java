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

    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        char[] array = new char[255];
        char[] array2 = new char[255];
        for(int i=0; i< s.length(); i++){
            if(array[s.charAt(i)] == 0){
                array[s.charAt(i)] = t.charAt(i);
            }else if(array[s.charAt(i)] != t.charAt(i)){
                return false;
            }

            if(array2[t.charAt(i)] == 0){
                array2[t.charAt(i)] = s.charAt(i);
            }else if (array2[t.charAt(i)] != s.charAt(i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Isomorphic i = new Isomorphic();
        System.out.println(i.isIsomorphic("egg","add"));
        System.out.println(i.isIsomorphic("foo","app"));
        System.out.println(i.isIsomorphic("turtle","tletur"));
        System.out.println(i.isIsomorphic("ab","ca"));
        System.out.println(i.isIsomorphic("foo","bar"));
        System.out.println(i.isIsomorphic("ab","aa"));
    }
}
