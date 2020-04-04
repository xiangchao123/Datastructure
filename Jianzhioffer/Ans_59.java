package offer;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * Created by xiangchao on 2020/3/29.
 */
public class Ans_59 {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> max = new ArrayList<>();
        if(num==null||num.length<=0||size<=0||size>num.length)
            return max;
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        for(int i=0;i<size-1;i++){
            while (!arrayDeque.isEmpty()&&num[i]>num[arrayDeque.getLast()])
                arrayDeque.removeLast();
            arrayDeque.addLast(i);//试试用add
        }
        for(int i=size-1;i<num.length;i++){
            while (!arrayDeque.isEmpty()&&num[i]>num[arrayDeque.getLast()])
                arrayDeque.removeLast();
            if(!arrayDeque.isEmpty()&&(i-arrayDeque.getFirst())>=size)
                arrayDeque.removeFirst();
            arrayDeque.addLast(i);
            max.add(num[arrayDeque.getFirst()]);
        }
        return max;
    }
}
