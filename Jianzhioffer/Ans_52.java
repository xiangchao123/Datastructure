package offer;

/**
 * Created by xiangchao on 2020/3/19.
 */
public class Ans_52 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1==null||pHead2==null){
            return null;
        }
        int len1 = getListLength(pHead1);
        int len2 = getListLength(pHead2);
        ListNode listLong = pHead1;
        ListNode listshort= pHead2;
        int needmove = len1-len2;
        if(len2>len1){
            listLong = pHead2;
            listshort=pHead1;
            needmove=len2-len1;
        }
        for(int i=0;i<needmove;i++){
            listLong=listLong.next;
        }
        while (listLong!=null&&listshort!=null&&listLong!=listshort){
            listLong=listLong.next;
            listshort=listshort.next;
        }
        return listLong;

    }
    public int getListLength(ListNode pHead){
        int len=0;
        ListNode head = pHead;
        while (head!=null){
            len++;
            head=head.next;
        }
        return len;
    }
}
