package offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by xiangchao on 2020/2/20.
 */
public class Ans_32_3 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public void Print(TreeNode root) {
        if(root==null){
            return;
        }
        Stack<TreeNode> oddStack = new Stack<>();
        Stack<TreeNode> evenStack = new Stack<>();
        oddStack.push(root);
        while(!oddStack.isEmpty()||!evenStack.isEmpty()){
            while (!oddStack.isEmpty()){
                TreeNode node = oddStack.pop();
                System.out.print(node.val +" ");
                if(oddStack.isEmpty()){
                    System.out.println();
                }
                if(node.left!=null){
                    evenStack.push(node.left);
                }
                if(node.right!=null){
                    evenStack.push(node.right);
                }
            }
            while (!evenStack.isEmpty()){
                TreeNode node = evenStack.pop();
                System.out.println(node.val+" ");
                if(evenStack.isEmpty()){
                    System.out.println();
                }
                if(node.right!=null){
                    oddStack.push(node.right);
                }
                if(node.left!=null){
                    oddStack.push(node.left);
                }
            }
        }
    }
}
