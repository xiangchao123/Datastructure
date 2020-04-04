package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiangchao on 2020/3/26.
 */
public class Ans_54 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(pRoot==null||k<=0){
            return null;
        }
        List<TreeNode> list = new ArrayList<>();
        recursive(pRoot,list);
        if(k>list.size()){
            return null;
        }
        return list.get(k-1);
    }
    public  void recursive(TreeNode treeNode, List<TreeNode> list){
        if(treeNode == null){
            return;
        }

        recursive(treeNode.left,list);
        list.add(treeNode);
        recursive(treeNode.right,list);
    }

    public static void main(String[] args) {
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode10 = new TreeNode(10);
        TreeNode treeNode11 = new TreeNode(11);
        treeNode5.left=treeNode6;
        treeNode5.right=treeNode9;
        treeNode6.left=treeNode8;
        treeNode6.right=treeNode10;
        treeNode9.left=treeNode7;
        treeNode9.right=treeNode11;
        new Ans_54().KthNode(treeNode5,1);
    }
}
