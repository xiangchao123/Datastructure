package offer;

import java.math.BigDecimal;

/**
 * Created by xiangchao on 2020/2/18.
 */
public class Ans_25 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        ListNode mergeNode = null;
        if(list1.val<list2.val){
            mergeNode = list1;
            mergeNode.next = Merge(list1.next,list2);
        }
        else {
            mergeNode = list2;
            mergeNode.next = Merge(list1,list2.next);
        }
        return mergeNode;
    }


}
