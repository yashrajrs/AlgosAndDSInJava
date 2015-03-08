package practice.problemSolving.sortingAndSearching;

import java.util.Comparator;

/**
 * Comparator for {@link HeightWeightPair}.
 *
 * @author Yashraj R. Sontakke
 */
public class HeightWeightPairComparator implements Comparator<HeightWeightPair> {
    @Override
    public int compare(HeightWeightPair heightWeightPair, HeightWeightPair heightWeightPair2) {
        if (heightWeightPair.getHeight() != heightWeightPair2.getHeight()) {
            return heightWeightPair.getHeight().compareTo(heightWeightPair2.getHeight());
        }
        return heightWeightPair.getWeight().compareTo(heightWeightPair2.getWeight());
    }
}
