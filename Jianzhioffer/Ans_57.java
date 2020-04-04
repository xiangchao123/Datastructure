package offer;

import java.util.ArrayList;

/**
 * Created by xiangchao on 2020/3/27.
 */
public class Ans_57 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(array==null||array.length<2){
            return arrayList;
        }
        int left=0;
        int right=array.length-1;
        while (left<right){
            int found = array[left]+array[right];
            if(found==sum){
                arrayList.add(array[left]);
                arrayList.add(array[right]);
                return arrayList;
            }
            else if(found>sum)
                right--;
            else
                left++;
        }
        return arrayList;
    }

    public static void main(String[] args) {
        int[] a = {1,2,4,7,11,15};
        new Ans_57().FindNumbersWithSum(a,15);
    }
}
