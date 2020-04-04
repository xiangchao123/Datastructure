package offer;

/**
 * Created by xiangchao on 2020/2/17.
 */
public class Ans_23 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode MeetNode(ListNode pHead){
        if(pHead==null){
            return null;
        }
        ListNode pSlow = pHead;

        ListNode pFast = pSlow.next;

        pFast = pFast.next;
        while(pSlow!=null&&pFast!=null){
            if(pSlow==pFast){
                return pFast;
            }
            pSlow = pSlow.next;
            pFast = pFast.next;
            if(pFast!=null){
                pFast = pFast.next;
            }
        }
        return null;
    }
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        ListNode meetNode = MeetNode(pHead);
        if(meetNode==null){
            return null;
        }
        int i=1;
        ListNode re_meetNode = meetNode;
        meetNode = meetNode.next;
        while (re_meetNode!=meetNode){
            i++;
            meetNode = meetNode.next;
        }
        ListNode bNode = pHead;
        for(int j=0;j<i;j++){
            bNode=bNode.next;
        }
        ListNode bNode1 = pHead;
        while (bNode1!=bNode){
            bNode=bNode.next;
            bNode1=bNode1.next;
        }
        return bNode;
    }
}
