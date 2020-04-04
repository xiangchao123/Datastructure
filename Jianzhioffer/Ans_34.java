package offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by xiangchao on 2020/2/21.
 */
public class Ans_34 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        if(root==null){
            return arrayLists;
        }
        Stack<Integer> stack = new Stack<>();
        findpath(root,stack,target,arrayLists);
        return arrayLists;
    }
    public void findpath(TreeNode root, Stack<Integer> stack,int target,ArrayList<ArrayList<Integer>> arrayLists){
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null){
            if(root.val==target){
                ArrayList<Integer> arrayList = new ArrayList<>();
                for(Integer integer:stack){
                    arrayList.add(integer);
                }
                arrayList.add(root.val);
                arrayLists.add(arrayList);
            }
        }
        else {
            stack.push(root.val);
            findpath(root.left,stack,target-root.val,arrayLists);
            findpath(root.right,stack,target-root.val,arrayLists);
            if(!stack.isEmpty())
            stack.pop();
        }
    }
}
