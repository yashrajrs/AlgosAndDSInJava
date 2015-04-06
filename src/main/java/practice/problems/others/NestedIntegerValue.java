package practice.problems.others;

import java.util.Stack;

/**
 * /**
 * Given a nested list of integers, returns the sum of all integers in the list weighted by their depth
 * For example, given the list {{1,1},2,{1,1}} the function should return 10 (four 1's at depth 2, one 2 at depth 1)
 * Given the list {1,{4,{6}}} the function should return 27 (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3)
 *
 * @author Yashraj R. Sontakke
 */
public class NestedIntegerValue {

    public void getValue(String input) {
        Stack<Character> stack = new Stack<Character>();
        Integer value = 0;
        Integer count = 0;
        for (Character c : input.toCharArray()) {
            if (c.equals('{')) {
                stack.push(c);
                count++;
            } else if (c.hashCode() >= 48 && c.hashCode() <= 57) {
                stack.push(c);
            } else if (c.equals(',')) {
                continue;
            } else {
                if (c.equals('}')) {
                    while (!stack.isEmpty()) {
                        Character pop = stack.pop();
                        if (pop.equals('{')) {
                            break;
                        }
                        value = value + count * (pop.hashCode() - 48);
                    }
                    count--;
                }
            }
        }

        if (!stack.isEmpty()) {
            throw new IllegalStateException("Wrong input");
        }
        System.out.println(value);
    }

    public static void main(String[] args) {
        NestedIntegerValue n = new NestedIntegerValue();
        n.getValue("{{1,1},2,{1,1}}");
        n.getValue("{1,{4,{6}}}");
    }
}
