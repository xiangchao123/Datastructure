package offer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by xiangchao on 2020/2/25.
 */
public class Ans_41 {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(11, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });
    public void Insert(Integer num) {
       if(((minHeap.size()+maxHeap.size())&1)==0){//为偶数，新数插入小顶堆
           if(!maxHeap.isEmpty()&&maxHeap.peek()>num){
               maxHeap.offer(num);
               num = maxHeap.poll();
           }
           minHeap.offer(num);
       }
        else {//为奇数，新数插入大顶堆
           if(!minHeap.isEmpty()&&minHeap.peek()<num){
               minHeap.offer(num);
               num = minHeap.poll();
           }
           maxHeap.offer(num);
       }
    }

    public Double GetMedian() {
        if(maxHeap.size()+minHeap.size()==0){
             throw new  RuntimeException();
        }
        double median;
        if(((maxHeap.size()+minHeap.size())&1)==0){
            median = (maxHeap.peek()+minHeap.peek())/2.0;
        }else {
            median = minHeap.peek();
        }
        return median;
    }

}
