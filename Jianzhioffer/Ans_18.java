package offer;

/**
 * Created by xiangchao on 2020/2/12.
 */
public class Ans_18 {

    public class ListNode {
        //属性定义成公开的方便调用和使用
        public int data;
        //公有属性
        public ListNode next;

    }
    public void deleteNode1(ListNode pHead, ListNode pDelNode){
        if(pHead==null||pDelNode==null){
            return;
        }
        //删除的不是尾结点
        if(pDelNode.next!=null){
            ListNode pNext = pDelNode.next;
            pDelNode.data = pNext.data;
            pDelNode.next = pNext.next;
            return;
        }
        //删除头结点，即只有一个节点
        else if(pDelNode==pHead){
            pDelNode=null;
            pHead=null;
            return;
        }
        //删除尾结点，存在多个节点
        else{
            ListNode pNode = pHead;
            while (pNode.next!=pDelNode){
                pNode = pNode.next;
            }
            pNode.next=null;
            return;
        }

    }
}
