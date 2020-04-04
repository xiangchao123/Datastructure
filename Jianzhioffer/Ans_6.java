package offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by xiangchao on 2020/1/31.
 */
public class Ans_6 {
    public class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();
        if(listNode==null) return result;
        Stack<Integer> stack = new Stack<>();

        ListNode listNode1 = listNode;
        while(listNode1!=null){
            stack.push(listNode1.val);
            listNode1 = listNode1.next;
        }
        while (!stack.empty()){
            result.add(stack.peek());
            stack.pop();
        }
        for(Integer integer:result){
            System.out.println(integer);
        }
        return result;
    }
}
