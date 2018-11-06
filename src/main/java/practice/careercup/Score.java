package practice.careercup;

/**
 * Created by yashraj on 7/20/16.
 */
public class Score {
    long hotelId;
    long userId;
    long score;

    public Score(long hotelId, long userId, long score) {
        this.hotelId = hotelId;
        this.userId = userId;
        this.score = score;
    }

    public long getHotelId() {
        return hotelId;
    }

    public long getUserId() {
        return userId;
    }

    public long getScore() {
        return score;
    }
}
