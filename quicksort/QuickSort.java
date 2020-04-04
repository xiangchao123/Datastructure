package quicksort;

/**
 * Created by xiangchao on 2020/2/5.
 */
public class QuickSort {
    public static void quicksort(int[] data,int length,int start,int end){
        if(start==end){
            return;
        }
        int index = QuickSort.partion(data,length,start,end);
        if (index < 0) {
            return;
        }
        if(index>start){
            QuickSort.quicksort(data,length,start,index-1);
        }
        if(index<end){
            QuickSort.quicksort(data,length,index+1,end);
        }
    }
    public static int partion(int[] data,int length,int start,int end){
        if(data==null||length<=0||start<0||end>=length){
            return -1;
        }
        int small = start-1;
        for(int index=start;index<end;index++){
            if(data[index]<data[end]){
                small++;
                if(small!=index){
                    QuickSort.swap(data,small,index);
                }
            }
        }
        small++;
        QuickSort.swap(data,small,end);
        return small;
    }

    public static void main(String[] args) {
        int[] arr = {};
        QuickSort.quicksort(arr,6,-1,5);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    public static void swap(int[] da,int i,int j){
        int temp = da[i];
        da[i] = da[j];
        da[j] = temp;
    }
}
