package offer;

/**
 * Created by xiangchao on 2020/3/23.
 */
public class Ans_53_2 {
    public int getMissingNumber(int[] array){
        if(array==null||array.length==0){
            return -1;
        }
        int left=0;
        int right=array.length-1;
        while (left<=right){
            int middle = (left+right)>>1;
            if(array[middle]!=middle){
                if(middle==0||array[middle-1]==middle-1){
                    return middle;
                }
                right=middle-1;
            }
            else {
                left = middle+1;
            }
        }
        if(left==array.length){
            return left;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a ={0,1,2,3};
        System.out.println(new Ans_53_2().getMissingNumber(a));
    }
}
