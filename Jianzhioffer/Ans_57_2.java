package offer;

import java.util.ArrayList;

/**
 * Created by xiangchao on 2020/3/27.
 */
public class Ans_57_2 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        if(sum<3){
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        int small=1;
        int big=2;
        int middle=(1+sum)/2;
        int cursum=small+big;
        while (small<middle){
            if(cursum==sum){
                arrayLists.add(getlist(small,big));
                big++;
                cursum+=big;
            }
            else if(cursum<sum) {
                big++;
                cursum += big;
            }
            else{
                cursum-=small;
                small++;

            }
        }
        return arrayLists;
    }
    public ArrayList<Integer> getlist(int a,int b){
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(;a<=b;a++){
            arrayList.add(a);
        }
        return arrayList;
    }

    public static void main(String[] args) {
        new Ans_57_2().FindContinuousSequence(9);
    }
}
