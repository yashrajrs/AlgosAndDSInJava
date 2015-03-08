package practice.problemSolving.sortingAndSearching;

/**
 * Object to store height and weight.
 *
 * @author Yashraj R. Sontakke
 */
public class HeightWeightPair {

    private final Integer height;
    private final Integer weight;

    public HeightWeightPair(final Integer height, final Integer weight) {
        this.height = height;
        this.weight = weight;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return String.format("( %d, %d)", height,weight);
    }
}
