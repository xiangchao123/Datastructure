package offer;

/**
 * Created by xiangchao on 2020/2/2.
 */
public class Ans_8 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode parent;
        TreeNode(int x) { val = x; }
    }
    public TreeNode GetNext(TreeNode pNode) {
        if(pNode==null){
            return null;
        }
        if(pNode.right!=null){
            pNode = pNode.right;
            while (pNode.left!=null){
                pNode=pNode.left;
            }
            return pNode;
        }
        while (pNode.parent!=null){
            if(pNode==pNode.parent.left){
                return pNode.parent;
            }
            pNode=pNode.parent;
        }
        return null;
    }
}