package practice.dataStructures.linkedList;

/**
 * Object for holding node information.
 *
 * @author Yashraj R. Sontakke
 */
public class Node {

    private Node prev, next;
    private final Object data;

    public Node(final Object data) {
        this.data = data;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public Node getNext() {
        return next;
    }

    public Object getData() {
        return data;
    }
}
