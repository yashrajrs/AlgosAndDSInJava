package practice.problemSolving.recursion;

/**
* Implements box object.
*
* @author Yashraj R. Sontakke
*/
public class Box {
    private final Integer length, height, breadth;

    public Box(Integer length, Integer height, Integer breadth) {
        this.length = length;
        this.breadth = breadth;
        this.height = height;
    }

    public Integer getLength() {
        return length;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getBreadth() {
        return breadth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Box box = (Box) o;

        if (breadth != null ? !breadth.equals(box.breadth) : box.breadth != null) return false;
        if (height != null ? !height.equals(box.height) : box.height != null) return false;
        if (length != null ? !length.equals(box.length) : box.length != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = length != null ? length.hashCode() : 0;
        result = 31 * result + (height != null ? height.hashCode() : 0);
        result = 31 * result + (breadth != null ? breadth.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Box{" +
                "length=" + length +
                ", height=" + height +
                ", breadth=" + breadth +
                '}';
    }
}
