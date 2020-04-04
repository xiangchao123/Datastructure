package offer;

/**
 * Created by xiangchao on 2020/2/23.
 */
public class Ans_37 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

    }

    String Serialize(TreeNode root) {
       StringBuilder stringBuilder = new StringBuilder();
        if(root==null){
            stringBuilder.append("#,");
            return stringBuilder.toString();
        }
        stringBuilder.append(root.val+",");
        stringBuilder.append(Serialize(root.left));
        stringBuilder.append(Serialize(root.right));

        return stringBuilder.toString();
    }
    int index = 0;
    TreeNode Deserialize(String str) {
        TreeNode treeNode = null;
        if(str==null||str.length()==0){
            return treeNode;
        }
        int start = index;
        while (str.charAt(index)!=','){
            index++;
        }
        if(!str.substring(start,index).equals("#")){
            treeNode = new TreeNode(Integer.parseInt(str.substring(start,index)));
            index++;
            treeNode.left = Deserialize(str);
            treeNode.right = Deserialize(str);
        }
        else {
            index++;
        }
        return treeNode;
    }
}
