package offer;

/**
 * Created by xiangchao on 2020/1/31.
 */
public class Ans_7 {
    public static class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode parent;
             TreeNode(int x) { val = x; }
         }
    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
      TreeNode root =  reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
        return root;
    }

    // 前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
    private static TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if(startPre>endPre||startIn>endIn){
            return null;
        }
        TreeNode root = new TreeNode(pre[startPre]);
        for(int j=0;j<in.length;j++){
            if(in[j]==pre[startPre]){
                root.left=reConstructBinaryTree(pre,startPre+1,j-startIn+startPre,in,startIn,j-1);
                root.right=reConstructBinaryTree(pre,j-startIn+startPre+1,endPre,in,j+1,endIn);
            }
        }
       return root;
    }




}
