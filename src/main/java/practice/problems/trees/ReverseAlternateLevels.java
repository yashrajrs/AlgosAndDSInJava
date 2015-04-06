package practice.problems.trees;

import practice.dataStructures.trees.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: yashrajsontakke
 * Date: 4/1/15
 * Time: 10:48 PM
 * To change this template use File | Settings | File Templates.
 *
 * @author Yashraj R. Sontakke
 */
public class ReverseAlternateLevels {

    public void convert(TreeNode root){
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();

        int count = 1;
        list.add(root);
        list.add(null);

        ArrayList<TreeNode> current = new ArrayList<TreeNode>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        while (!list.isEmpty()){
            TreeNode node = list.remove(0);

            if (node !=null){
                current.add(node);
                if (node.getLeftChild()!=null){
                    list.add(node.getLeftChild());
                }
                if(node.getRightChild()!=null){
                    list.add(node.getRightChild());
                }
            }else if (list.isEmpty()){
                if (count%2==0){
                    addMap(map,current,reverse(current));
                }else{
                    addMap(map,current,current);
                }

            }else{
                list.add(null);

                if (count%2==0){
                    addMap(map,current,reverse(current));
                }else{
                    addMap(map,current,current);
                }
                count++;
                current = new ArrayList<TreeNode>();
            }
        }
        System.out.println(map.toString());

        inOrderDataChange(root,map);

        inOrder(root);

    }

    public void inOrderDataChange(TreeNode node, HashMap<Integer,Integer> map){
        if (node == null){
            return;
        }
        inOrderDataChange(node.getLeftChild(),map);
        node.setData(map.get(node.getData()));
        inOrderDataChange(node.getRightChild(),map);
    }

    public void inOrder(TreeNode node){
        if (node == null){
            return;
        }
        inOrder(node.getLeftChild());
        System.out.print( node.getData() + " ");
        inOrder(node.getRightChild());
    }

    public void addMap(HashMap<Integer,Integer> map, ArrayList<TreeNode> input, ArrayList<TreeNode> output){

        for (int i=0;i<input.size();i++){
            map.put(input.get(i).getData(),output.get(i).getData());
        }
    }

    public ArrayList<TreeNode> reverse(ArrayList<TreeNode> input){
        ArrayList<TreeNode> output = new ArrayList<TreeNode>();
        for (int i = input.size()-1;i>=0;i--){
            output.add(input.get(i));
        }
        System.out.println(output.toString());
        return output;
    }

    public static void main(String[] args){
        ReverseAlternateLevels r = new ReverseAlternateLevels();
        TreeNode node1 = new TreeNode(1);

        TreeNode node2 = new TreeNode(10);
        TreeNode node3 = new TreeNode(20);

        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(5);
        TreeNode node7 = new TreeNode(6);

//        TreeNode node8 = new TreeNode(30);
//        TreeNode node9 = new TreeNode(40);
//        TreeNode node10 = new TreeNode(50);
//        TreeNode node11 = new TreeNode(60);

        node1.setLeftChild(node2);
        node1.setRightChild(node3);

        node2.setLeftChild(node4);
        node2.setRightChild(node5);

        node3.setLeftChild(node6);
        node3.setRightChild(node7);

//        node4.setLeftChild(node8);
//        node4.setRightChild(node9);
//
//        node5.setLeftChild(node10);
//        node6.setRightChild(node11);

        r.convert(node1);
    }
}
