package practice.problems;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Checks if addition of elements of two lists is equal to elements of third list.
 *
 * @author Yashraj R. Sontakke
 */
public class APlusBEqualsC {

    public boolean isAPlusBEqualsC(final ArrayList<Long> a, final ArrayList<Long> b,
                                   final ArrayList<Long> c) {

        while (!a.isEmpty() && !b.isEmpty() && !c.isEmpty()) {
            if (a.get(0) + b.get(0) != c.get(0)) {
                return false;
            }

            a.remove(0);
            b.remove(0);
            c.remove(0);
        }

        while (!a.isEmpty() && !c.isEmpty()) {
            if (a.get(0) != c.get(0)) {
                return false;
            }
            a.remove(0);
            c.remove(0);
        }

        while (!b.isEmpty() && !c.isEmpty()) {
            if (b.get(0) != c.get(0)) {
                return false;
            }
            b.remove(0);
            c.remove(0);
        }


        if (a.isEmpty() && b.isEmpty() && c.isEmpty()) {
            return true;
        }
        if ((!a.isEmpty() || !b.isEmpty() && c.isEmpty()) || (a.isEmpty() && b.isEmpty()) && !c.isEmpty()) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        APlusBEqualsC aPlusBEqualsC = new APlusBEqualsC();

        final ArrayList<Long> a1 = new ArrayList<Long>(Arrays.asList(1L, 2L, 3L, 4L));
        final ArrayList<Long> b1 = new ArrayList<Long>(Arrays.asList(2L, 3L, 4L, 5L));
        final ArrayList<Long> c1 = new ArrayList<Long>(Arrays.asList(3L, 5L, 7L, 9L));

        final ArrayList<Long> a2 = new ArrayList<Long>(Arrays.asList(1L, 2L, 3L, 4L));
        final ArrayList<Long> b2 = new ArrayList<Long>(Arrays.asList(2L, 3L, 4L, 5L));
        final ArrayList<Long> c2 = new ArrayList<Long>(Arrays.asList(3L, 5L, 7L, 10L));


        final ArrayList<Long> a3 = new ArrayList<Long>(Arrays.asList(2L, 3L, 4L));
        final ArrayList<Long> b3 = new ArrayList<Long>(Arrays.asList(2L, 3L, 4L, 5L));
        final ArrayList<Long> c3 = new ArrayList<Long>(Arrays.asList(3L, 5L, 7L, 9L));

        final ArrayList<Long> a4 = new ArrayList<Long>(Arrays.asList(1L, 2L, 3L, 4L));
        final ArrayList<Long> b4 = new ArrayList<Long>(Arrays.asList(2L, 3L, 4L));
        final ArrayList<Long> c4 = new ArrayList<Long>(Arrays.asList(3L, 5L, 7L, 9L));

        final ArrayList<Long> a5 = new ArrayList<Long>(Arrays.asList(1L, 2L, 3L, 4L));
        final ArrayList<Long> b5 = new ArrayList<Long>(Arrays.asList(2L, 3L, 4L, 5L));
        final ArrayList<Long> c5 = new ArrayList<Long>(Arrays.asList(2L, 3L, 4L));

        final ArrayList<Long> a6 = new ArrayList<Long>(Arrays.asList(1L, 2L));
        final ArrayList<Long> b6 = new ArrayList<Long>(Arrays.asList(2L, 3L, 4L));
        final ArrayList<Long> c6 = new ArrayList<Long>(Arrays.asList(3L, 5L, 7L, 9L));

        final ArrayList<Long> a7 = new ArrayList<Long>(Arrays.asList(1L, 2L, 3L, 4L));
        final ArrayList<Long> b7 = new ArrayList<Long>(Arrays.asList(2L, 3L));
        final ArrayList<Long> c7 = new ArrayList<Long>(Arrays.asList(3L, 5L, 7L));

        final ArrayList<Long> a8 = new ArrayList<Long>(Arrays.asList(1L, 2L, 3L));
        final ArrayList<Long> b8 = new ArrayList<Long>(Arrays.asList(2L, 3L, 4L, 5L));
        final ArrayList<Long> c8 = new ArrayList<Long>(Arrays.asList(3L, 5L));


        System.out.println(aPlusBEqualsC.isAPlusBEqualsC(a1, b1, c1));
        System.out.println(aPlusBEqualsC.isAPlusBEqualsC(a2, b2, c2));
        System.out.println(aPlusBEqualsC.isAPlusBEqualsC(a3, b3, c3));
        System.out.println(aPlusBEqualsC.isAPlusBEqualsC(a4, b4, c4));
        System.out.println(aPlusBEqualsC.isAPlusBEqualsC(a5, b5, c5));
        System.out.println(aPlusBEqualsC.isAPlusBEqualsC(a6, b6, c6));
        System.out.println(aPlusBEqualsC.isAPlusBEqualsC(a7, b7, c7));
        System.out.println(aPlusBEqualsC.isAPlusBEqualsC(a8, b8, c8));

    }
}
