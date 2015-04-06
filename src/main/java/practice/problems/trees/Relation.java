package practice.problems.trees;

/**
* Created with IntelliJ IDEA.
* User: yashrajsontakke
* Date: 4/1/15
* Time: 8:06 PM
* To change this template use File | Settings | File Templates.
*
* @author Yashraj R. Sontakke
*/
public class Relation {
    private final Integer child;
    private final Integer parent;
    private final boolean isLeft;

    public Relation(final Integer child, final Integer parent, final boolean isLeft) {
        this.child = child;
        this.parent = parent;
        this.isLeft = isLeft;
    }

    public Integer getChild() {
        return child;
    }

    public Integer getParent() {
        return parent;
    }

    public boolean isLeft() {
        return isLeft;
    }
}
