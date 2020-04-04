package offer;

/**
 * Created by xiangchao on 2020/2/22.
 */
public class Ans_36 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public TreeNode Convert(TreeNode pRootOfTree) {
        TreeNode pLastNodeInList = null;
        pLastNodeInList = ConvertSubTree(pRootOfTree,pLastNodeInList);
        while(pLastNodeInList!=null&&pLastNodeInList.left!=null){
            pLastNodeInList = pLastNodeInList.left;
        }
        return pLastNodeInList;
    }
    public TreeNode ConvertSubTree(TreeNode pRootOfTree,TreeNode pLastNodeInList){
        if(pRootOfTree==null){
            return pLastNodeInList ;
        }
        if(pRootOfTree.left!=null){
            pLastNodeInList = ConvertSubTree(pRootOfTree.left,pLastNodeInList);
        }
        TreeNode pCurrentNode = pRootOfTree;
        pCurrentNode.left=pLastNodeInList;
        if(pLastNodeInList!=null){
            pLastNodeInList.right = pCurrentNode;
        }
        pLastNodeInList = pCurrentNode;
        if(pRootOfTree.right!=null){
            pLastNodeInList = ConvertSubTree(pRootOfTree.right,pLastNodeInList);
        }
        return pLastNodeInList;

    }
}
