package offer;

/**
 * Created by xiangchao on 2020/2/24.
 */
public class Ans_39_1 {
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array==null||array.length==0){
            return 0;
        }
        int start = 0;
        int end = array.length-1;
        int middle = end>>1;
        int index = Partition(array,start,end);
        while(index!=middle){
            if(index<0){
                return 0;
            }
            if(index>middle){
                end = index-1;
                index = Partition(array,start,end);
            }
            else {
                start = index+1;
                index = Partition(array,start,end);
            }
        }
        int numbers = array[index];
        int times = 0;
        for(int i=0;i<array.length;i++){
            if(array[i]==numbers)
                times++;
        }
        if(2*times<=array.length){
            return 0;
        }
        return numbers;
    }
    public int Partition(int[] array,int start,int end){
        if(array==null||start<0||end>=array.length){
            return -1;
        }
        int small = start-1;
        for(int index = start;index<end;index++){
            if(array[index]<array[end]){
                small++;
                if(small!=index){
                    swap(array,small,index);
                }
            }
        }
        small++;
        swap(array,small,end);
        return small;
    }
    public void swap(int[]  array,int i,int j){
        int temp = array[i];
        array[i] =  array[j];
        array[j] = temp;
    }
}
