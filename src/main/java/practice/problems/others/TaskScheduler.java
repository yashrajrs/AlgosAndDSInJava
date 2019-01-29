package practice.problems.others;

import java.util.Arrays;

/**
 * Created by yashraj on 1/23/19.
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
