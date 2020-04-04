package offer;

/**
 * Created by xiangchao on 2020/3/26.
 */
public class Ans_55_2 {
    private boolean flag=true;
    public boolean IsBalanced_Solution(Ans_55.TreeNode root) {
        getDepth(root);
        return flag;

    }
    public int getDepth(Ans_55.TreeNode root) {
        if(root==null){
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if(Math.abs((left-right))>1){
            flag=false;
        }
        return (left>=right)?left+1:right+1;
    }

}
