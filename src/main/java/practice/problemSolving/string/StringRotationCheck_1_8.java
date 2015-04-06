package practice.problemSolving.string;

/**
 * Assume you have a method isSubstring which checks if one word is a substring
 * of another. Given two strings, si and s2, write code to check Ifs2 is a rotation of si
 * using only one call to isSubstring (e.g., "waterbottLe" is a rotation of "erbottLewat").
 *
 * @author Yashraj R. Sontakke
 */
public class StringRotationCheck_1_8 {

    public boolean isRotation(String s1, String s2) {
        if (s1.length() > 0 && s1.length() == s2.length()) {
            s1 = s1 + s1;
            return isSubString(s1, s2);
        }
        return false;
    }

    private boolean isSubString(String s1, String s2) {
        return s1.contains(s2);
    }


    public static void main(String[] args) {
        StringRotationCheck_1_8 stringRotationCheck = new StringRotationCheck_1_8();
        System.out.println(stringRotationCheck.isRotation("erbottLewat", "waterbottLe"));
        System.out.println(stringRotationCheck.isRotation("erbottLewat", "waterbottL"));
    }
}
