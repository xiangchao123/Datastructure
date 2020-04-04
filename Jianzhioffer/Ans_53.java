package offer;

/**
 * Created by xiangchao on 2020/3/23.
 */
public class Ans_53 {
    public int GetNumberOfK(int [] array , int k) {

        int number=0;
        if(array!=null&&array.length!=0) {
            int first = getFirst(array, k, 0, array.length - 1);
            int last = getLast(array, k, 0, array.length - 1);
            if (first > -1 && last > -1) {
                number = last - first + 1;
            }
        }
        return number;
    }
    public int getFirst(int[] array,int k,int start,int end){
        if(start>end){
            return -1;
        }
        int middleindex = (start+end)/2;
        int middledata = array[middleindex];
        if(middledata==k){
            if(middleindex>0&&array[middleindex-1]!=k||middleindex==0){
                return middleindex;
            }
            else {
                end = middleindex-1;
            }
        }
        else if(middledata<k){
            start=middleindex+1;
        }
        else {
            end = middleindex-1;
        }
        return getFirst(array,k,start,end);
    }
    public int getLast(int[] array,int k,int start,int end){
        if(start>end){
            return -1;
        }
        int middleindex = (start+end)/2;
        int middledata = array[middleindex];
        if(middledata==k){
            if(middleindex<array.length-1&&array[middleindex+1]!=k||middleindex==array.length-1){
                return middleindex;
            }
            else {
                start = middleindex+1;
            }
        }
        else if(middledata<k){
            start=middleindex+1;
        }
        else {
            end = middleindex-1;
        }
        return getLast(array,k,start,end);
    }

    public static void main(String[] args) {
        int[] a={1,2,3,3,3,3,4,5};
        new Ans_53().GetNumberOfK(a,3);
    }
}
