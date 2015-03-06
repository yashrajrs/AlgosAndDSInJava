package practice.problemSolving.string;

/**
 * Implement a method to perform basic string compression using the counts
 * of repeated characters. For example, the string aabcccccaaa would become
 * a2blc5a3. If the "compressed" string would not become smaller than the original
 * string, your method should return the original string
 *
 * @author Yashraj R. Sontakke
 */
public class StringCompress_1_5 {

    public void formatString(String input) {
        if (input == null || input.length() <= 1) {
            System.out.println(input);
            return;
        }
        String output = "";
        char current = input.charAt(0);
        int count = 1;
        for (int i = 1; i < input.length(); i++) {
            if (current == input.charAt(i)) {
                count++;
            } else {
                output = String.format("%s%c%d", output, current, count);
                current = input.charAt(i);
                count = 1;
            }
        }
        if (output.length() < input.length()) {
            System.out.println(output);
        } else {
            System.out.println(input);
        }
    }

    public static void main(String[] args) {
        StringCompress_1_5 s = new StringCompress_1_5();
        s.formatString("aabcccccaaa");
        s.formatString("abca");
    }
}
