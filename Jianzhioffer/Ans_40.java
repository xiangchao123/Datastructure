package offer;

import java.util.ArrayList;

/**
 * Created by xiangchao on 2020/2/24.
 */
public class Ans_40 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(input==null||input.length==0||k>input.length||k<=0){
            return arrayList;
        }
        int start = 0;
        int end = input.length-1;
        int index = Partition(input,start,end);
        while(index!=k-1){
            if(index>k-1){
                start = index+1;
                index = Partition(input,start,end);
            }
            else {
                end = index-1;
                index = Partition(input,start,end);
            }
        }
        for(int i=0;i<k;i++){
            arrayList.add(input[i]);
        }
        return arrayList;

    }
    public int Partition(int[] input,int start,int end){
        if(input==null||start<0||end>input.length){
            return -1;
        }
        int small = start-1;
        for(int index = start;index<end;index++){
            if(input[index]<input[end]){
                small++;
                if(small!=index){
                    swap(input,small,index);
                }
            }
        }
        small++;
        swap(input,small,end);
        return small;
    }
    public void swap(int[] input,int i,int j){
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    public static void main(String[] args) {
        int[] input = {4,5,1,6,2,7,3,8};
        int k=4;
        new Ans_40().GetLeastNumbers_Solution(input,k);
    }
}
