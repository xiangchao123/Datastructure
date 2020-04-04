package offer;

/**
 * Created by xiangchao on 2020/2/21.
 */
public class Ans_35 {
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
    public RandomListNode Clone(RandomListNode pHead)
    {
        CloneNode(pHead);
        ConnectSiblingNodes(pHead);
        return ReconnectNodes(pHead);
    }

    public void CloneNode(RandomListNode pHead){
        RandomListNode pNode = pHead;
        while (pNode!=null){
            RandomListNode pClone = new RandomListNode(pNode.label);
            pClone.next = pNode.next;
            pClone.random = null;
            pNode.next = pClone;
            pNode = pClone.next;
        }
    }
    public void ConnectSiblingNodes(RandomListNode pHead){
        RandomListNode pNode = pHead;
        while (pNode!=null){
            RandomListNode pClone = pNode.next;
            if(pNode.random!=null){
                pClone.random = pNode.random.next;
            }
            pNode = pClone.next;
        }
    }
    public RandomListNode ReconnectNodes(RandomListNode pHead){
        RandomListNode pNode = pHead;
        RandomListNode pCloneHead = null;
        RandomListNode pCloneNode = null;
        if(pNode!=null){
            pCloneHead = pNode.next;
            pCloneNode = pCloneHead;
            pNode.next = pCloneNode.next;
            pNode = pNode.next;
        }
        while (pNode!=null){

                pCloneNode.next = pNode.next;
                pCloneNode = pCloneNode.next;
                pNode.next = pCloneNode.next;
                pNode = pNode.next;

        }

        return pCloneHead;
    }
}
