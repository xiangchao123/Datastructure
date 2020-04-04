package offer;

import java.util.ArrayDeque;

/**
 * Created by xiangchao on 2020/3/29.
 */
public class Ans_59_2 {
    ArrayDeque<InsertData> data = new ArrayDeque<>();
    ArrayDeque<InsertData> max = new ArrayDeque<>();
    private class InsertData{
        int number;
        int index;
        public InsertData(int number,int index) {
            this.number = number;
            this.index = index;
        }
    }
    private int curindex;
    public void push_back(int number){
        InsertData insertData = new InsertData(number,curindex);
        data.addLast(insertData);
        while (!max.isEmpty()&&max.getLast().number<number)
            max.removeLast();
        max.addLast(insertData);
        curindex++;
    }
    public void pop_front(){
        if(data.isEmpty()){
            System.out.println("wei kong");
            return;
        }
        InsertData curData = data.removeFirst();
        if(curData.index==max.getFirst().index)
            max.removeFirst();
    }
    public int max(){
        if(max==null){
            System.out.println("weikong");
            return 0;
        }
        return max.getFirst().number;
    }
}
