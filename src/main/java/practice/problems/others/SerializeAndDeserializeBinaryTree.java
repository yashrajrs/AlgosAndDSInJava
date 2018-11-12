package practice.problems.others;

import org.apache.commons.lang3.SerializationUtils;
import practice.dataStructures.trees.BinarySearchTree;
import practice.dataStructures.trees.TreeNode;

import java.util.*;

/**
 * Serialize and deserialize binary tree
 *
 * @author Yashraj R. Sontakke
 */
public class SerializeAndDeserializeBinaryTree {


    public void convert(TreeNode node) {
        printInOrder(node);
        System.out.println();

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        populateArrayInOrder(arrayList, node);
        arrayList.add(0, arrayList.size());
        populateArrayPreOrder(arrayList, node);

        Integer[] array = arrayList.toArray(new Integer[arrayList.size()]);

        byte[] serialize = SerializationUtils.serialize(array);

        Integer[] deserialize = SerializationUtils.deserialize(serialize);

        List<Integer> list = Arrays.asList(deserialize);

        ArrayList<Integer> list1 = new ArrayList<Integer>(list.subList(1, deserialize[0] + 1));
        ArrayList<Integer> list2 = new ArrayList<Integer>(list.subList(deserialize[0] + 1, deserialize.length));

        TreeNode root = createBinaryTree(list1, list2);
        printInOrder(root);
        System.out.println();


    }

    public TreeNode createBinaryTree(ArrayList<Integer> inOrderList, ArrayList<Integer> preOrderList) {
        if (inOrderList == null || inOrderList.isEmpty() || preOrderList == null || preOrderList.isEmpty()) {
            return null;
        }

        Integer data = preOrderList.get(0);
        TreeNode root = new TreeNode(data);
        Integer rootIndex = inOrderList.indexOf(data);
        preOrderList.remove(root.getData());

        ArrayList<Integer> leftInOrder = new ArrayList<Integer>(inOrderList.subList(0, rootIndex));
        ArrayList<Integer> rightInOrder = new ArrayList<Integer>(inOrderList.subList(rootIndex + 1, inOrderList.size()));
        TreeNode leftChild = createBinaryTree(leftInOrder, preOrderList);
        TreeNode rightChild = createBinaryTree(rightInOrder, preOrderList);
        root.setLeftChild(leftChild);
        root.setRightChild(rightChild);
        if (leftChild != null) {
            leftChild.setParent(root);
        }
        if (rightChild != null) {
            rightChild.setParent(root);
        }
        return root;

    }


    public void populateArrayInOrder(ArrayList<Integer> arrayList, TreeNode node) {
        if (node == null) {
            return;
        }
        populateArrayInOrder(arrayList, node.getLeftChild());
        arrayList.add(node.getData());
        populateArrayInOrder(arrayList, node.getRightChild());
    }

    public void populateArrayPreOrder(ArrayList<Integer> arrayList, TreeNode node) {
        if (node == null) {
            return;
        }
        arrayList.add(node.getData());
        populateArrayInOrder(arrayList, node.getLeftChild());
        populateArrayInOrder(arrayList, node.getRightChild());
    }

    public void printInOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        printInOrder(node.getLeftChild());
        System.out.print(node.getData() + " ");
        printInOrder(node.getRightChild());
    }

    public void convert1(TreeNode node) {
        Integer[] array = getLevelOrderArray(node);

        byte[] serialize = SerializationUtils.serialize(array);

        Integer[] deserialize = SerializationUtils.deserialize(serialize);

        TreeNode root = createTree(deserialize);
        printInOrder(root);
        System.out.println();
    }

    public TreeNode createTree(Integer[] array) {
        TreeNode root = new TreeNode(array[0]);

        for (int i = 1; i < array.length; i++) {
            TreeNode newNode = new TreeNode(array[i]);
            if (root.getData() > newNode.getData() && root.getLeftChild() == null) {
                root.setLeftChild(newNode);
                newNode.setParent(root);
            } else if (root.getData() < newNode.getData() && root.getRightChild() == null) {
                root.setRightChild(newNode);
                newNode.setParent(root);
            } else {
                TreeNode node = root;
                while (node != null && (node.getData() > newNode.getData() && node.getLeftChild() != null) || (node.getData() < newNode.getData() && node.getRightChild() != null)) {
                    if (node.getData() > newNode.getData()) {
                        node = node.getLeftChild();
                    } else {
                        node = node.getRightChild();
                    }
                }
                if (node.getData() > newNode.getData()) {
                    node.setLeftChild(newNode);
                    newNode.setParent(root);
                } else {
                    node.setRightChild(newNode);
                    newNode.setParent(root);
                }
            }
        }
        return root;
    }

    public Integer[] getLevelOrderArray(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        queue.add(node);
        queue.add(new TreeNode(Integer.MIN_VALUE));

        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.remove();
            if (treeNode.getData() != Integer.MIN_VALUE) {
                list.add(treeNode.getData());
                if (treeNode.getLeftChild() != null) {
                    queue.add(treeNode.getLeftChild());
                }
                if (treeNode.getRightChild() != null) {
                    queue.add(treeNode.getRightChild());
                }
            } else if (queue.isEmpty()) {
                break;
            } else {
                queue.add(new TreeNode(Integer.MIN_VALUE));
            }

        }
        return list.toArray(new Integer[list.size()]);

    }

    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                sb.append(node.getData()+",");
                queue.add(node.getLeftChild());
                queue.add(node.getRightChild());
            } else {
                sb.append("#,");
            }
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0)
            return null;

        String[] arr = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));


        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            if (t == null) {
                continue;
            }
            if (!arr[i].equals("#")) {
                t.setLeftChild(new TreeNode(Integer.parseInt(arr[i])));
                queue.offer(t.getLeftChild());
            } else {
                t.setLeftChild(null);
                queue.offer(null);
            }
            i++;
            if (!arr[i].equals("#")) {
                t.setRightChild(new TreeNode(Integer.parseInt(arr[i])));
                queue.offer(t.getRightChild());
            } else {
                t.setRightChild(null);
                queue.offer(null);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        BinarySearchTree b = new BinarySearchTree();
        b.addData(80);
        b.addData(73);
        b.addData(78);
        b.addData(60);
        b.addData(85);
        b.addData(90);

        SerializeAndDeserializeBinaryTree serializeAndDeserializeBinaryTree = new SerializeAndDeserializeBinaryTree();
//        serializeAndDeserializeBinaryTree.convert(b.parent);
//
//        serializeAndDeserializeBinaryTree.convert1(b.parent);

        String st = serializeAndDeserializeBinaryTree.serialize(b.parent);
        System.out.println(st);

        System.out.println(serializeAndDeserializeBinaryTree.deserialize(st));

    }
}
