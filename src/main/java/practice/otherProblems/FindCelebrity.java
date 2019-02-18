//package practice.otherProblems;
//
///**
// * Created by yashraj on 2/14/19.
// */
//public class FindCelebrity extends FindCelebrity.Relation{
//
//    public int findCelebrity(int n) {
//        int start = 0;
//        int end = n-1;
//        while (start<end) {
//            if (knows(start, end)) {
//                start++;
//            } else {
//                end--;
//            }
//        }
//        for (int i=0;i<n;i++) {
//            if (i != start  && (knows(start, i) ||  !knows(i, start))) {
//                return -1;
//            }
//        }
//        return start;
//    }
//
//    public class Relation {
//        boolean knows(int a, int b) {
//            return true;
//        }
//    }
//}
