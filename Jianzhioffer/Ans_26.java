package offer;

import java.math.BigDecimal;

/**
 * Created by xiangchao on 2020/2/18.
 */
public class Ans_26 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result=false;
        if(root1!=null&&root2!=null){
            if(root1.val==root2.val){
                result = DoesTree1HasTree2(root1, root2);
            }
            if(!result){
                result = HasSubtree(root1.left,root2);
            }
            if(!result){
                result = HasSubtree(root1.right,root2);
            }
        }
        return result;
    }
    public boolean DoesTree1HasTree2(TreeNode root1,TreeNode root2){
        if(root2==null){
            return true;
        }
        if(root1==null){
            return false;
        }
        if(root1.val!=root2.val){
            return false;
        }
        return DoesTree1HasTree2(root1.left,root2.left)&&DoesTree1HasTree2(root1.right,root2.right);
    }

    public static void main(String[] args) {
        BigDecimal b1 = new BigDecimal("2.0");
        BigDecimal b2 = new BigDecimal("1.1");
        BigDecimal b3 = new BigDecimal("0.9");
        System.out.println(b1.subtract(b2).equals(b3));
        System.out.println(b1.equals(b2));
        double a1=2.0;
        double a2=1.1;
        System.out.println(a1-a2);
        System.out.println(0.9==(a1-a2));
    }

}
