package practice.dataStructures.trees;

/**
 * Implement Binary Tree
 *
 * @author Yashraj R. Sontakke
 */
public class BinarySearchTree {

    public TreeNode parent;

    /**
     * Adds data to the binary tree.
     *
     * @param data the data to be added
     */
    public void addData(Integer data) {
        TreeNode newNode = new TreeNode(data);
        if (parent == null) {
            parent = newNode;
        } else if (parent.getData() > data && parent.getLeftChild() == null) {
            parent.setLeftChild(newNode);
            newNode.setParent(parent);
        } else if (parent.getData() < data && parent.getRightChild() == null) {
            parent.setRightChild(newNode);
            newNode.setParent(parent);
        } else {


            TreeNode currentNode = parent;

            while (currentNode != null && ((currentNode.getData() > data && currentNode.getLeftChild() != null) ||
                    currentNode.getData() < data && currentNode.getRightChild() != null)) {
                if (currentNode.getData() > data) {
                    currentNode = currentNode.getLeftChild();
                } else {
                    currentNode = currentNode.getRightChild();
                }
            }

            if (currentNode.getData() > data) {
                currentNode.setLeftChild(newNode);
                newNode.setParent(currentNode);
            } else {
                currentNode.setRightChild(newNode);
                newNode.setParent(currentNode);
            }

        }
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

    /**
     * Prints pre order tree for the node provided
     */
    public void printPreOrder(final TreeNode node) {
        if (node != null) {
            System.out.println(node.getData());
            printPreOrder(node.getLeftChild());
            printPreOrder(node.getRightChild());
        }
    }

    /**
     * Prints post order tree for the node provided
     */
    public void printPostOrder(final TreeNode node) {
        if (node != null) {
            printPostOrder(node.leftChild);
            printPostOrder(node.rightChild);
            System.out.println(node.data);
        }
    }

    /**
     * Performs binary search for the data provided
     */
    public TreeNode binarySearch(final Integer data, final TreeNode parent) {
        if (parent == null || parent.getData() == data) {
            return parent;
        } else if (parent.getData() > data) {
            return binarySearch(data, parent.getLeftChild());
        } else {
            return binarySearch(data, parent.getRightChild());
        }
    }

    /**
     * Finds the tree minimum for the node provided
     */
    public TreeNode treeMinimum(TreeNode node) {
        while (node.getLeftChild() != null) {
            node = node.getLeftChild();
        }
        return node;
    }

    /**
     * Finds the tree maximum for the node provided
     */
    public TreeNode treeMaximum(TreeNode node) {
        while (node.getRightChild() != null) {
            node = node.getRightChild();
        }
        return node;
    }

    /**
     * Finds the successor for the node provided
     */
    public TreeNode findSuccessor(TreeNode node) {
        if (node.getRightChild() != null) {
            return treeMinimum(node.getRightChild());
        } else {
            TreeNode node1 = node.getParent();
            while (node1 != null && node == node1.getRightChild()) {
                node = node1;
                node1 = node1.getParent();
            }
            return node1;
        }
    }

    /**
     * Deletes a node from the tree
     *
     * @param data
     */
    public void deleteData(Integer data) {
        TreeNode node = binarySearch(data, parent);
        if (node == null) {
            return;
        }

        TreeNode rightChild = node.getRightChild();
        TreeNode leftChild = node.getLeftChild();
        if (leftChild == null && rightChild != null) {
            TreeNode node1 = node.getParent();
            node1.setRightChild(rightChild);
            rightChild.setParent(node1);
        } else if (leftChild != null && rightChild == null) {
            TreeNode node1 = node.getLeftChild();
            node1.setLeftChild(leftChild);
            leftChild.setParent(node1);
        } else if (leftChild == null && rightChild == null) {
            TreeNode node1 = node.getParent();
            if (node1.getLeftChild() == node) {
                node1.setLeftChild(null);
            } else {
                node1.setRightChild(null);
            }
            node.setParent(null);
        } else {
            TreeNode successor = findSuccessor(node);
            if (node.rightChild == successor) {
                TreeNode node1 = node.getParent();
                node1.setRightChild(successor);
                successor.setParent(node1);
            } else {
                TreeNode y = successor.getParent();
                y.setLeftChild(successor.getRightChild());
                TreeNode n1 = node.getParent();
                n1.setRightChild(successor);
                successor.setLeftChild(node.getLeftChild());
                successor.setRightChild(node.getRightChild());
            }
        }


    }


    public static void main(String[] args) {
        BinarySearchTree b = new BinarySearchTree();
        b.addData(80);
        b.addData(73);
        b.addData(78);
        b.addData(60);
        b.addData(85);
        b.addData(90);
        b.deleteData(60);
        System.out.println();
        b.printInOrder(b.parent);
        TreeNode treeNode = b.binarySearch(793, b.parent);
        if (treeNode != null) {
            System.out.println(treeNode.data);
        } else {
            System.out.println("NODE not found");
        }
    }

}
