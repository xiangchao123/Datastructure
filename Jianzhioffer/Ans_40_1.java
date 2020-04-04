package offer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by xiangchao on 2020/2/25.
 */
public class Ans_40_1 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(input==null||input.length==0||k>input.length||k<=0){
            return arrayList;
        }
        int length = input.length;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for(int i=0;i<length;i++){
            if(maxHeap.size()!=k){
                maxHeap.offer(input[i]);
            }
            else if(maxHeap.peek()>input[i]){
                maxHeap.poll();
                maxHeap.offer(input[i]);
            }
        }
        for(Integer integer:maxHeap){
            arrayList.add(integer);
        }
        return arrayList;
    }
}
