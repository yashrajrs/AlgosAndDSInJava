package practice.careercup;

import java.util.*;

/**
 * You have rating (0-10) of the hotels per user in this format:

 scores = [
 {'hotel_id': 1001, 'user_id': 501, 'score': 7},
 {'hotel_id': 1001, 'user_id': 502, 'score': 7},
 {'hotel_id': 1001, 'user_id': 503, 'score': 7},
 {'hotel_id': 2001, 'user_id': 504, 'score': 10},
 {'hotel_id': 3001, 'user_id': 505, 'score': 5},
 {'hotel_id': 2001, 'user_id': 506, 'score': 5}
 ]

 Any given hotel might have more than one score.

 Implement a function, get_hotels(scores, min_avg_score) that returns a list of hotel ids that have average score equal to or higher than min_avg_score.

 get_hotels(scores, 5) -> [1001, 2001, 3001]
 get_hotels(scores, 7) -> [1001, 2001]

*/
public class HotelIdUserScores {


    public List<Long> getHotels(ArrayList<Score> list, int minAvgScore) {
        List<Long> result = new ArrayList<Long>();
        Map<Long, List<Long>> hotelsByScore = new HashMap<Long, List<Long>>();

        for (Score score: list) {
            if (!hotelsByScore.containsKey(score.getHotelId())) {
                ArrayList<Long> l1 = new ArrayList<Long>();
                l1.add(score.getScore());
                hotelsByScore.put(score.getHotelId(), l1);
            } else {
                List<Long> l1 = hotelsByScore.get(score.getHotelId());
                l1.add(score.getScore());
            }
        }
        for(Map.Entry<Long, List<Long>> entry : hotelsByScore.entrySet()) {
            int avg = 0;
            for (Long s1: entry.getValue()) {
                avg+=s1;
            }
            avg/= entry.getValue().size();
            if (avg >= minAvgScore) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        HotelIdUserScores h = new HotelIdUserScores();
        ArrayList<Score> list = new ArrayList<Score>();
        Score s1 = new Score(1001, 501, 7);
        Score s2 = new Score(1001, 502, 7);
        Score s3 = new Score(1001, 503, 7);
        Score s4 = new Score(2001, 504, 10);
        Score s5 = new Score(3001, 505, 5);
        Score s6 = new Score(2001, 506, 5);
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);
        list.add(s6);
        System.out.println(h.getHotels(list, 5).toString());
        System.out.println(h.getHotels(list, 7).toString());
    }

}
