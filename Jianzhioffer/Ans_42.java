package offer;

/**
 * Created by xiangchao on 2020/3/13.
 */
public class Ans_42 {
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array==null||array.length==0){
            return 0;
        }
        int max=array[0];
        int cursum=0;
        for(int i=0;i<array.length;i++){
            if(cursum<=0)
                cursum=array[i];
            else{
                cursum +=array[i];
            }
            if(cursum>max){
                max = cursum;
            }
        }
        return max;
    }
    public int FindGreatestSumOfSubArray2(int[] array) {
        if(array==null||array.length==0){
            return 0;
        }
        int max=array[0];
        int subarr=array[0];
        for(int i=1;i<array.length;i++){
            subarr = Math.max(subarr+array[i],array[i]);
            max = Math.max(max,subarr);
        }
        return max;
    }
}
