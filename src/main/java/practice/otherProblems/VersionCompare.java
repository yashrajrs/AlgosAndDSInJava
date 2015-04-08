package practice.otherProblems;

/**
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
 * <p/>
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * The . character does not represent a decimal point and is used to separate number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
 * <p/>
 * Here is an example of version numbers ordering:
 * <p/>
 * 0.1 < 1.1 < 1.2 < 13.37
 *
 * @author Yashraj R. Sontakke
 */
public class VersionCompare {
    public int compareVersion(String version1, String version2) {
        String[] number1 = version1.split("\\.");
        String[] number2 = version2.split("\\.");

        int i = 0, j = 0, a = 0, b = 0;
        while (i < number1.length || j < number2.length) {
            if (i < number1.length) {
                a = Integer.parseInt(number1[i]);
            }
            if (j < number2.length) {
                b = Integer.parseInt(number2[j]);
            }
            if (a > b) {
                return 1;
            } else if (a < b) {
                return -1;
            }
            i++;
            j++;
            a = 0;
            b = 0;
        }
        return 0;
    }

    public static void main(String[] args) {
        VersionCompare v = new VersionCompare();
        System.out.println(v.compareVersion("0.1", "1.1"));
        System.out.println(v.compareVersion("2.1", "1.1"));
        System.out.println(v.compareVersion("1.1.2", "1.1"));
        System.out.println(v.compareVersion("1.1.2", "1.1.2"));
    }
}
