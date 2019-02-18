package practice.otherProblems;

/**
 * Validate if a given string can be interpreted as a decimal number.

 Some examples:
 "0" => true
 " 0.1 " => true
 "abc" => false
 "1 a" => false
 "2e10" => true
 " -90e3   " => true
 " 1e" => false
 "e3" => false
 " 6e-1" => true
 " 99e2.5 " => false
 "53.5e93" => true
 " --6 " => false
 "-+3" => false
 "95a54e53" => false

 Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one. However, here is a list of characters that can be in a valid decimal number:

 Numbers 0-9
 Exponent - "e"
 Positive/negative sign - "+"/"-"
 Decimal point - "."
 Of course, the context of these characters also matters in the input.


 */
public class ValidNumber {

    public boolean isNumber(String s) {
       if (s == null) {
           return false;
       }
        s = s.trim();
        if (s.length() == 0) {
            return false;
        }
        boolean point = false, exponent = false, sign = false, number = false;
        for (int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if (!Character.isDigit(c)) {
                if (c != '.' && c != '+' && c != '-' && c != 'e') {
                    return false;
                }
                if (c == '.') {
                    if (point) {
                        return false;
                    } else if (exponent) {
                        return false;
                    } else {
                        point = true;
                    }
                }
                if (c == 'e') {
                    if (exponent) {
                        return false;
                    }
                    if (!number) {
                        return false;
                    }
                    exponent = true;
                    number = false;
                }
                if (c == '+' || c == '-') {
                    if (i==0) {
                        sign = true;
                    } else {
                        if (s.charAt(i-1) != 'e') {
                            return false;
                        }
                    }
                }

            } else {
                number = true;
            }
        }
        return number;
    }


    public static void main(String[] args) {
        ValidNumber v  = new ValidNumber();

        System.out.println(v.isNumber("0")); // true
        System.out.println(v.isNumber(" 0.1 ")); // true
        System.out.println(v.isNumber("abc")); // false
        System.out.println(v.isNumber("1 a")); // false
        System.out.println(v.isNumber("2e10")); // true
        System.out.println(v.isNumber(" -90e3   ")); // true
        System.out.println(v.isNumber(" 1e")); // false
        System.out.println(v.isNumber("e3")); // false
        System.out.println(v.isNumber(" 6e-1")); // true
        System.out.println(v.isNumber(" 99e2.5 ")); // false
        System.out.println(v.isNumber("53.5e93")); // true
        System.out.println(v.isNumber(" --6 ")); // false
        System.out.println(v.isNumber("-+3")); // false
        System.out.println(v.isNumber("95a54e53")); // false
    }

}

