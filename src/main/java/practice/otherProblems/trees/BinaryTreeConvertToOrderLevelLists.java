package practice.otherProblems.trees;

import practice.otherProblems.TreeLinkNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Link all the level order nodes to makes a linked list with the first node of each level acting as the root of that linklist.
 * <p/>
 * <p/>
 * 10
 * / \
 * 6 17
 * / / \
 * 4	14 19
 * So the Linklist will be
 * 10->null
 * 6->17->null
 * 4->14->19->null
 *
 * @author Yashraj R. Sontakke
 */
public class BinaryTreeConvertToOrderLevelLists {

    public List<TreeLinkNode> getLists(TreeLinkNode root){
        List<TreeLinkNode> result = new ArrayList<TreeLinkNode>();
        if (root == null){
            return result;
        }
        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            TreeLinkNode first = null;
            for(int i=0;i<size;i++){
                TreeLinkNode node = queue.remove();
                if (i == 0){
                    first = node;
                }
                if (node.left !=null){
                    node.left.next = node.right;
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
                if (node.right != null && node.next !=null){
                    node.right.next = node.next.left;

                }
            }
            result.add(first);
        }
        return result;
    }

    public static void main(String[] args){
        BinaryTreeConvertToOrderLevelLists b = new BinaryTreeConvertToOrderLevelLists();
        TreeLinkNode n1 = new TreeLinkNode(10);
        TreeLinkNode n2 = new TreeLinkNode(6);
        TreeLinkNode n3 = new TreeLinkNode(17);
        TreeLinkNode n4 = new TreeLinkNode(1);
        TreeLinkNode n5 = new TreeLinkNode(2);
        TreeLinkNode n6 = new TreeLinkNode(3);
        TreeLinkNode n7 = new TreeLinkNode(4);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        List<TreeLinkNode> result=  b.getLists(n1);

        for(TreeLinkNode node : result){
            TreeLinkNode node1 = node;
            while(node1!=null){
                System.out.print(node1.val + " ");
                node1 = node1.next;
            }
            System.out.println();
        }
    }
}
