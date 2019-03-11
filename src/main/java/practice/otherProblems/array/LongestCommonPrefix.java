package practice.otherProblems.array;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * @author Yashraj R. Sontakke
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        int minLen = Integer.MAX_VALUE;
        for(String str: strs){
            if(minLen > str.length()){
                minLen = str.length();
            }
        }
        if(minLen==0){
            return "";
        }

        for(int j=0;j<minLen;j++){
            char prev = '0';
            for(int i=0;i<strs.length;i++){
                if(i==0){
                    prev = strs[i].charAt(j);
                    continue;
                }

                if(prev != strs[i].charAt(j)){
                    return strs[0].substring(0, j);
                }
            }
        }
        return strs[0].substring(0, minLen);
    }

    public static void main(String[] args){
        LongestCommonPrefix l = new LongestCommonPrefix();

        String[] input1 = {"yash", "yashraj", "yas"};
        System.out.println(l.longestCommonPrefix(input1));

        String[] input2 = {"yash", "yash"};
        System.out.println(l.longestCommonPrefix(input2));

        String[] input3= {"yash", "raj"};
        System.out.println(l.longestCommonPrefix(input3));

    }
}
