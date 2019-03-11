package practice.problems.trees;

import practice.otherProblems.TreeNode;

import java.util.Stack;

/**
 * Created by yashraj on 3/8/19.
 */
public class MergeBinaryTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) {
            return null;
        }
        if(t1 == null) {
            return t2;
        }
        if(t2 == null) {
            return t1;
        }
        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[] {t1, t2});

        while(!stack.isEmpty()) {
            TreeNode[] t = stack.pop();
            if(t[0] == null || t[1] == null) {
                continue;
            }
            t[0].val += t[1].val;
            if(t[0].left == null) {
                t[0].left = t[1].left;
            } else {
                stack.push(new TreeNode[] {t[0].left,t[1].left});
            }

            if(t[0].right == null) {
                t[0].right = t[1].right;
            } else {
                stack.push(new TreeNode[] {t[0].right, t[1].right});
            }
        }
        return t1;

    }
}
