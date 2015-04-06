package practice.dataStructures.trees;

/**
 * Object for holding tree node information.
 *
 * @author Yashraj R. Sontakke
 */
public class TreeNode {

    public void setData(Integer data) {
        this.data = data;
    }

    Integer data;
    TreeNode leftChild;
    TreeNode rightChild;
    TreeNode parent;

    public TreeNode(final Integer data) {
        this.data = data;
    }

    public Integer getData() {
        return data;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return String.format("{data=%d}",data);
    }
}
