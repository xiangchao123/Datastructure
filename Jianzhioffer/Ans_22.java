package offer;

/**
 * Created by xiangchao on 2020/2/17.
 */
public class Ans_22 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head==null||k==0){
            return null;
        }
        ListNode pAHead = head;
        ListNode pBHead = head;
        for(int i=1;i<=k-1;i++){
            if(pAHead.next!=null){
                pAHead=pAHead.next;
            }
            else {
                return null;
            }
        }
        while (pAHead.next!=null){
            pAHead=pAHead.next;
            pBHead=pBHead.next;
        }
        return pBHead;
    }
}
