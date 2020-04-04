package offer;

/**
 * Created by xiangchao on 2020/3/24.
 */
public class Ans_53_3 {
    public int getNumberSameAsIndex(int[] array){
        if(array==null||array.length==0){
            return -1;
        }
        int left=0;
        int right=array.length-1;
        while (left<=right){
            int middleindex = (left+right)>>1;
            if(array[middleindex]==middleindex){
                return middleindex;
            }
            else if(array[middleindex]>middleindex){
                right = middleindex - 1;
            }
            else {
                left = middleindex + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a=null ;
        System.out.println(new Ans_53_3().getNumberSameAsIndex(a));
    }
}
