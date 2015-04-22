package practice.problemSolving.string;

/**
 * Write a method to replace all spaces in a string with'%20'. You may assume that
 * the string has sufficient space at the end of the string to hold the additional
 * characters, and that you are given the "true" length of the string. (Note: if implementing
 * in Java, please use a character array so that you can perform this operation
 * in place.)
 * EXAMPLE
 * Input: "Mr John Smith     "
 * Output: "Mr%20Dohn%20Smith"
 *
 * @author Yashraj R. Sontakke
 */
public class StringReplace_1_4 {


    public void replace(char[] stringArray) {
        char[] stringArray2 = new char[stringArray.length];
        int j = 0;
        for (int i = 0; i <= stringArray.length - 1; i++) {
            if (j == stringArray.length) {
                break;
            }
            if (stringArray[i] != ' ') {
                stringArray2[j] = stringArray[i];
                j++;
            } else {
                stringArray2[j] = '%';
                stringArray2[j + 1] = '2';
                stringArray2[j + 2] = '0';
                j = j + 3;
            }
        }
        System.out.println(new String(stringArray2));
    }

    public void formatString(char[] input) {
        int j = input.length - 1;
        boolean characterEncountered = false;
        for (int i = input.length - 1; i >= 0; i--) {
            if (input[i] == ' ') {
                if (!characterEncountered) {
                    continue;
                } else {
                    input[j] = '0';
                    input[j - 1] = '2';
                    input[j - 2] = '%';
                    j = j - 3;
                }
            } else {
                input[j] = input[i];
                j--;
                characterEncountered = true;
            }
        }
        System.out.println(new String(input));
    }

    public static void main(String[] args) {
        StringReplace_1_4 s = new StringReplace_1_4();
        char[] stringArray = {'M', 'Y', ' ', 'N', 'A', 'M', 'E', ' ', 'I', 'S', ' ', 'Y', 'A', 'S', 'H', 'R', 'A', 'J', ' ', ' ', ' ', ' ', ' ', ' '};
        s.replace(stringArray);
        s.formatString(stringArray);
    }
}
