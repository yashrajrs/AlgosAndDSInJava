package practice.otherProblems.string;

/**
 * Write a function that accepts two character arrays each represents a floating point number and return their sum in character array.
 * For example function accepts "23.45" and "2.5" and return their sum "25.95".
 * Restriction: We cannot use predefined functions / methods or parsing. We have to go with basic operations.
 *
 * @author Yashraj R. Sontakke
 */
public class AddFloatingPointNumbers {

    public String add(String a, String b) {
        String[] a1 = a.split("\\.");
        String[] b1 = b.split("\\.");
        String aDecimal = a1.length == 2 ? a1[1] : "";
        String bDecimal = b1.length == 2 ? b1[1] : "";

        String afterDecimal = addAfterDecimal(aDecimal, bDecimal);

        String beforeDecimal = addBeforeDecimal(a1[0], b1[0]);


        int maxLenDecimal = Math.max(aDecimal.length(), bDecimal.length());
        String newString = "";
        if (maxLenDecimal < afterDecimal.length()){
            while (maxLenDecimal != afterDecimal.length()){
                newString = newString + afterDecimal.charAt(0);
                afterDecimal = afterDecimal.substring(1);
            }
        }
        beforeDecimal = addBeforeDecimal(beforeDecimal, newString);

            return beforeDecimal + "." + afterDecimal;
    }

    public String addAfterDecimal(String a, String b) {
        int index = Math.max(a.length(), b.length()) - 1;
        int val = 0;
        String output = "";

        while (index >= 0) {
            if (index < a.length()) {
                val += a.charAt(index) - '0';
            }
            if (index < b.length()) {
                val += b.charAt(index) - '0';
            }
            output = val % 10 + output;
            val /= 10;
            index--;
        }
        if (val > 0) {
            output = val + output;
        }
        return output;
    }

    public String addBeforeDecimal(String a, String b) {
        int indexA = a.length() - 1;
        int indexB = b.length() - 1;

        int val = 0;
        String output = "";
        while (indexA >= 0 || indexB >= 0) {
            if (indexA >= 0) {
                val += a.charAt(indexA) - '0';
                indexA--;
            }
            if (indexB >= 0) {
                val += b.charAt(indexB) - '0';
                indexB--;
            }
            output = val % 10 + output;
            val /= 10;
        }
        if (val > 0) {
            output = val + output;
        }
        return output;
    }


    public static void main(String[] args) {
        AddFloatingPointNumbers a = new AddFloatingPointNumbers();

//        System.out.println(a.addBeforeDecimal("111", "222"));
//        System.out.println(a.addBeforeDecimal("111", "22"));
//
//        System.out.println(a.addAfterDecimal("111", "222"));
//        System.out.println(a.addAfterDecimal("111", "22"));

        System.out.println(a.add("23.45", "2.5"));
        System.out.println(a.add("23.45", "2.55"));
    }


}
