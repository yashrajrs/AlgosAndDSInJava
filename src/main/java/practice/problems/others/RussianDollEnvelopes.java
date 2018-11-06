package practice.problems.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.

 What is the maximum number of envelopes can you Russian doll? (put one inside other)

 Note:
 Rotation is not allowed.

 Example:

 Input: [[5,4],[6,4],[6,7],[2,3]]
 Output: 3
 Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 */
public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]) {
                    return o1[0] -o2[0];
                } else {
                    return o1[1] -o2[1];
                }
            }
        });
        int max = 1;
        int[] arr = new int[envelopes.length];
        for (int i=0;i<envelopes.length;i++) {
            arr[i] = 1;
            for (int j=i-1;j>=0;j--) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    arr[i] = Math.max(arr[i], arr[j]+1);
                }
            }
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    // Binary Search
    public int maxEnvelopes2(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]) {
                    return o1[0] -o2[0];
                } else {
                    return o1[1] -o2[1];
                }
            }
        });
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<envelopes.length;i++) {
            if(list.isEmpty() || list.get(list.size()-1) < envelopes[i][1]) {
                list.add(envelopes[i][1]);
            }
            int l=0;
            int r=list.size()-1;
            while (l<r) {
                int mid = l + (r-l)/2;
                if (list.get(mid) < envelopes[i][1]) {
                    l = mid+1;
                } else {
                    r = mid;
                }
            }
            list.set(r, envelopes[i][1]);
        }
        return list.size();
    }

    public static void main(String[] args) {
        RussianDollEnvelopes russianDollEnvelopes = new RussianDollEnvelopes();
        int[][] input = {{5,4}, {6,4}, {6,7},{2,3}};
        System.out.println(russianDollEnvelopes.maxEnvelopes(input));
        System.out.println(russianDollEnvelopes.maxEnvelopes2(input));
    }
}
