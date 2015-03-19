package practice.problems.trees;

import practice.dataStructures.trees.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Create a tree using preOrder and Inorder or PostOrder and Inorder.
 *
 * @author Yashraj R. Sontakke
 */
public class CreateTreeUsingInorderPreOrder {

    public TreeNode getTree(ArrayList<Integer> preOrder, ArrayList<Integer> inOrder) {
        if (preOrder.isEmpty() || inOrder.isEmpty()) {
            return null;
        }

        Integer data = preOrder.get(0);
        TreeNode root = new TreeNode(data);
        Integer inOrderIndex = inOrder.indexOf(data);

        ArrayList<Integer> leftInOrder = new ArrayList<Integer>(inOrder.subList(0, inOrderIndex));
        ArrayList<Integer> rightInOrder = new ArrayList<Integer>(inOrder.subList(inOrderIndex + 1, inOrder.size()));
        preOrder.remove(data);
        root.setLeftChild(getTree(preOrder, leftInOrder));
        root.setRightChild(getTree(preOrder, rightInOrder));

        return root;
    }

    public TreeNode getTree1(ArrayList<Integer> postOrder, ArrayList<Integer> inOrder) {
        if (postOrder.isEmpty() || inOrder.isEmpty()) {
            return null;
        }

        Integer data = postOrder.get(postOrder.size() - 1);
        TreeNode root = new TreeNode(data);
        Integer inOrderIndex = inOrder.indexOf(data);

        ArrayList<Integer> leftInOrder = new ArrayList<Integer>(inOrder.subList(0, inOrderIndex));
        ArrayList<Integer> rightInOrder = new ArrayList<Integer>(inOrder.subList(inOrderIndex + 1, inOrder.size()));
        postOrder.remove(data);
        root.setLeftChild(getTree(postOrder, leftInOrder));
        root.setRightChild(getTree(postOrder, rightInOrder));

        return root;
    }

    public static void main(String[] args) {
        ArrayList<Integer> preOrder = new ArrayList<Integer>(Arrays.asList(10, 5, 3, 1, 4, 15, 12, 18));
        ArrayList<Integer> inOrder = new ArrayList<Integer>(Arrays.asList(1, 3, 4, 5, 10, 12, 15, 18));
        ArrayList<Integer> postOrder = new ArrayList<Integer>(Arrays.asList(1, 4, 3, 5, 12, 18, 15, 10));

        CreateTreeUsingInorderPreOrder createTreeUsingInorderPreOrder = new CreateTreeUsingInorderPreOrder();
        TreeNode root = createTreeUsingInorderPreOrder.getTree(preOrder, inOrder);

        createTreeUsingInorderPreOrder.printInOrder(root);

        TreeNode root1 = createTreeUsingInorderPreOrder.getTree1(postOrder, inOrder);
        System.out.println();
        createTreeUsingInorderPreOrder.printInOrder(root1);
    }


    /**
     * Prints in order tree for the node provided
     */
    public void printInOrder(final TreeNode node) {
        if (node != null) {
            printInOrder(node.getLeftChild());
            System.out.println(node.getData());
            printInOrder(node.getRightChild());
        }
    }
}
