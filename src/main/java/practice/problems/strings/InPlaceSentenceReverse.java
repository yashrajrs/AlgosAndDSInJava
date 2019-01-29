package practice.problems.strings;

/**
 * Inplace reverse a sentence
 *
 * Example:
 * input "I wish you a merry Christmas"
 * output "Christmas merry a you wish I"

 * Constrains: O(1) additional memory
 *
 * @author Yashraj R. Sontakke
 */
public class InPlaceSentenceReverse {



    public void reverseSentence(String input){
        if (input.length() <=1 || !input.contains(" ")){
            return;
        }
        char[] charArray = input.toCharArray();
        int start = 0;
        for (int i =0;i<charArray.length;i++){
            if (charArray[i] ==' '){
                reverseWord(charArray, start, i-1);
                start = i+1;
            }
        }
        reverseWord(charArray, start, charArray.length);
        System.out.println(new String(charArray));
        char temp;
        for (int i =0;i<charArray.length/2;i++){
            temp = charArray[i];
            charArray[i] = charArray[charArray.length - 1-i];
            charArray[charArray.length-1-i] = temp;
        }

        System.out.println(new String(charArray));
    }

    public void reverseWord(char[] input, int start, int end){
//        if (end - start == 1){
//            return;
//        }
        if (end >=input.length){
            end = input.length - 1;
        }
        char temp;
        while(start <= end){
            temp = input[start];
            input[start] = input[end];
            input[end] = temp;
            start++;
            end--;

        }
    }

    public String reverseWords(String s) {
        if (s == null || s.length() == 0){
            return  "";
        }
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length -1; i>=0; i--){
            if (!arr[i].equals("")){
                sb.append(arr[i]).append(" ");
            }
        }
        return sb.length() == 0 ? "" : sb.substring(0, sb.length() -1);
    }

   public static void main(String[] args){
       String input =  "I wish you a merry Christmas";
       InPlaceSentenceReverse inPlaceSentenceReverse =new InPlaceSentenceReverse();
//       inPlaceSentenceReverse.reverseSentence(input);
       inPlaceSentenceReverse.reverseSentence("the sky is blue");
//       System.out.println(inPlaceSentenceReverse.reverseWords(input));
   }
}
