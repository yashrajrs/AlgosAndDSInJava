package practice.problemSolving.trees;

import com.google.common.collect.Sets;
import practice.dataStructures.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * You are given a binary tree in which each node contains a value. Design an algorithm
 * to print all paths which sum to a given value. The path does not need to
 * start or end at the root or a leaf.
 *
 * @author Yashraj R. Sontakke
 */
public class PathValue_4_9 {

    public Set<ArrayList<Integer>> paths = Sets.newHashSet();

    public void getPaths(TreeNode node, ArrayList<Integer> path, Integer value) {
        if (node == null) {
            if (sum(path) == value) {
                paths.add(path);
            }
            return;
        }

        ArrayList<Integer> newPath = new ArrayList<Integer>(path);
        newPath.add(node.getData());
        getPaths(node.getLeftChild(), path, value);
        getPaths(node.getRightChild(), path, value);
        getPaths(node.getLeftChild(), newPath, value);
        getPaths(node.getRightChild(), newPath, value);

    }

    public Integer sum(ArrayList<Integer> path) {
        Integer sum = 0;
        for (Integer value : path) {
            sum += value;
        }
        return sum;
    }

    public List<ArrayList<Integer>> getPaths(TreeNode node, Integer value) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (node == null) {
            return result;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(node.getData());
        dfs(node, value-node.getData(), result, list);
        return result;
    }

    public void dfs(TreeNode node, Integer sum, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list) {
        if (node.getLeftChild() == null && node.getRightChild() == null && sum == 0) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.addAll(list);
            result.add(temp);
        }

        if (node.getLeftChild() != null) {
            list.add(node.getLeftChild().getData());
            dfs(node.getLeftChild(), sum - node.getLeftChild().getData(), result, list);
            list.remove(list.size()-1);
        }

        if (node.getRightChild() != null) {
            list.add(node.getRightChild().getData());
            dfs(node.getRightChild(), sum - node.getRightChild().getData(), result, list);
            list.remove(list.size()-1);
        }
    }
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(1);
        TreeNode node6 = new TreeNode(3);
        TreeNode node7 = new TreeNode(1);

        node1.setLeftChild(node2);
        node1.setRightChild(node3);
        node2.setLeftChild(node4);
        node2.setRightChild(node5);
        node3.setLeftChild(node6);
        node3.setRightChild(node7);

        PathValue_4_9 pathValue = new PathValue_4_9();
        pathValue.getPaths(node1, new ArrayList<Integer>(), 10);

        System.out.println(pathValue.paths.toString());

        List<ArrayList<Integer>> paths = pathValue.getPaths(node1, 10);
        System.out.println(paths.toString());
    }
}
