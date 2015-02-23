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
        if (end - start == 1){
            return;
        }
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

   public static void main(String[] args){
       String input =  "I wish you a merry Christmas";
       InPlaceSentenceReverse inPlaceSentenceReverse =new InPlaceSentenceReverse();
       inPlaceSentenceReverse.reverseSentence(input);
   }
}
