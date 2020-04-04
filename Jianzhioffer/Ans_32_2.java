package offer;

import array.Array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by xiangchao on 2020/2/20.
 */
public class Ans_32_2 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public ArrayList<ArrayList<Integer>> PrintFromTopToBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        if(root==null){
            return arrayLists;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int nextLevel = 0;
        int toBePrinted =1;
        ArrayList<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.val);
            if(node.left!=null){
                queue.add(node.left);
                nextLevel++;
            }
            if(node.right!=null){
                queue.add(node.right);
                nextLevel++;
            }
            toBePrinted--;
            if(toBePrinted==0){
                toBePrinted=nextLevel;
                nextLevel=0;
                arrayLists.add(list);
                list = new ArrayList<>();
            }
        }
        return arrayLists;
    }
}
