package offer;

/**
 * Created by xiangchao on 2020/2/18.
 */
public class Ans_24 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode ReverseList(ListNode head) {
        ListNode reversedNode = null;
        ListNode pNode = head;
        ListNode preNode = null;
        while (pNode!=null){
            ListNode pNext = pNode.next;
            if(pNext==null){
                reversedNode = pNode;
            }
            pNode.next=preNode;
            preNode = pNode;
            pNode = pNext;
        }
        return reversedNode;
    }
}
