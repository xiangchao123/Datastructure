package offer;

import multithreading.PickRightForkRunnable;

/**
 * Created by xiangchao on 2020/2/12.
 */
public class Ans_18_2 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead==null){
            return null;
        }
        ListNode pPreNode = null;
        ListNode pNode = pHead;
        while (pNode!=null){
            ListNode pNext = pNode.next;
            boolean isduplication =false;
            if(pNext!=null&&pNode.val==pNext.val) {
                isduplication=true;
            }
            if(!isduplication){
                pPreNode=pNode;
                pNode=pNode.next;
            }
            else {
                int value = pNode.val;
                ListNode isTodel = pNode;
                while (isTodel!=null&&isTodel.val==value){
                    pNext = isTodel.next;
                    isTodel=pNext;
                }
                if(pPreNode==null){
                    pHead=pNext;
                }
                else {
                    pPreNode.next = pNext;
                }
            }
            pNode = pNext;
        }
        return pHead;
    }
}
