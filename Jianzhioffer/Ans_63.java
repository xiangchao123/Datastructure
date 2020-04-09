package offer;

/**
 * Created by xiangchao on 2020/4/9.
 */
public class Ans_63 {
    public static int MaxDiff(int[] arr) {
        if(arr==null||arr.length<2)
            return -1;
        int min=arr[0];
        int max=arr[1]-min;
        for(int i=1;i<arr.length;i++){
            if(arr[i-1]<min)
                min=arr[i-1];
            if(arr[i]-min>max)
                max=arr[i]-min;
        }
        return max;
    }
}
