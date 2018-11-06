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
        output = String.format("%s%c%d", output, current, count);

        if (output.length() < input.length()) {
            System.out.println(output);
        } else {
            System.out.println(input);
        }
    }

    public int compress(char[] chars) {
        if (chars.length == 1) {
            return 1;
        }
        String output = "";
        char current = chars[0];
        int count = 1;
        for (int i = 1;i <chars.length; i++) {
            if (current == chars[i]) {
                count++;
            } else {
                if (count > 1) {
                    output = String.format("%s%c%d", output, current, count);
                } else {
                    output = String.format("%s%c", output, current);
                }
                count = 1;
                current = chars[i];
            }
        }

        if (count > 1) {
            output = String.format("%s%c%d", output, current, count);
        } else {
            output = String.format("%s%c", output, current);
        }
        if (output.length() < chars.length) {
            return output.length();
        }
        return chars.length;
    }



    public static void main(String[] args) {
        StringCompress_1_5 s = new StringCompress_1_5();
//        s.formatString("aabcccccaaa");
//        s.formatString("abca");


        System.out.println(s.compress(new String("aabbccc").toCharArray()));
        System.out.println(s.compress(new String("a").toCharArray()));
        System.out.println(s.compress(new String("abbbbbbbbbbbb").toCharArray()));

    }
}
