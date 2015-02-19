package practice.dataStructures;

/**
 * Object for holding node information.
 *
 * @author Yashraj R. Sontakke
 */
public class Node {
    public Node next;
    public final Object data;

    public Node(final Object data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public Object getData() {
        return data;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
