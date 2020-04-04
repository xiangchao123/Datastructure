package offer;

/**
 * Created by xiangchao on 2020/3/30.
 */
public class Ans_3_2 {
    public int getDuplicate(int[] arr){
        if(arr==null||arr.length<=0)
            return -1;
        for(int a:arr){
            if(a<1||a>arr.length-1){
                return -1;
            }
        }
        int low=1;
        int high=arr.length-1;
        int mid;
        int count;
        while (low<=high){
            mid = ((high-low)>>2)+low;
            count = countRange(arr,low,mid);
            if(low==high){
                if(count>1){
                    return low;
                }
                else
                    break;
            }
            if(count>mid-low+1)
                high = mid;
            else
                low = mid+1;
        }
        return -1;
    }

    private int countRange(int[] arr, int low, int high) {
        if(arr==null){
            return 0;
        }
        int count=0;
        for(int a:arr){
            if(a>=low&&a<=high)
                count++;
        }
        return count;
    }
}
