package practice.problems.others;

import java.util.Arrays;

/**
 *Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks. Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.

 However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.

 You need to return the least number of intervals the CPU will take to finish all the given tasks.



 Example:

 Input: tasks = ["A","A","A","B","B","B"], n = 2
 Output: 8
 Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
 */
public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c: tasks) {
            map[c-'A']++;
        }
        Arrays.sort(map);
        int time=0;
        while (map[25] > 0) {
            int i=0;
            while (i<=n) {
                if (map[25] == 0) {
                    break;
                }
                if (i<25 && map[25-i] > 0) {
                    map[25-i]--;
                }
                time++;
                i++;
            }
            Arrays.sort(map);
        }
        return time;
    }

    public static void main(String[] args) {
        TaskScheduler t = new TaskScheduler();
        char[] tasks = {'A','A','A','B','B','B'};
        System.out.println(t.leastInterval(tasks, 2));
    }

}
