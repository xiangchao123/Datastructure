package offer;

/**
 * Created by xiangchao on 2020/3/26.
 */
public class Ans_54_2 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    int j;
    TreeNode KthNode(TreeNode pRoot, int k){
        if(pRoot==null||k<=0){
            return null;
        }
        j=k;
        return recursive(pRoot);
    }
    TreeNode recursive(TreeNode treeNode){
        TreeNode temp = null;
        if(treeNode.left!=null)
           temp = recursive(treeNode.left);
        if(temp==null){
            if(j==1){
                temp = treeNode;
            }
            else
                j--;
        }
        if(temp==null&&treeNode.right!=null)
            temp = recursive(treeNode.right);
        return temp;
    }

}
