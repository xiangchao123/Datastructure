package offer;

/**
 * Created by xiangchao on 2020/2/6.
 */
public class Ans_11 {
    public int minNumberInRotateArray(int [] array) {
        if(array.length==0){
            return 0;
        }
        int index1=0;
        int index2=array.length-1;
        int indexMid=index1;
        while(array[index1]>=array[index2]){
            if(index2-index1==1){
                indexMid = index2;
                break;

            }
            indexMid = (index1+index2)/2;
            if(array[index1]==array[index2]&&array[index1]==array[indexMid]){
                return MinInOrder(array,index1,index2);
            }
            if(array[index1]<=array[indexMid]){
                index1=indexMid;
            }
            else {
                index2=indexMid;
            }
        }
        return array[indexMid];
    }
    public int MinInOrder(int[] array,int index1,int index2){
        int result = array[index1];
        for(int i = index1+1;i<=index2;i++){
            if(result>array[i]){
                result = array[i];
            }
        }
        return result;
    }
}
