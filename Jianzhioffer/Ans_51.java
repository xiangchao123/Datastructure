package offer;

/**
 * Created by xiangchao on 2020/3/19.
 */
public class Ans_51 {

    public int InversePairs(int [] array) {
        if(array==null||array.length==0){
            return 0;
        }
        int[] copy = new int[array.length];
        for(int i=0;i<array.length;i++){
            copy[i]=array[i];
        }
        int count = merge(array,copy,0,array.length-1);
        return count;
    }

    public int merge(int[] array,int[] copy,int left,int right){
        if(left==right){
            return 0;
        }
        int mid = (left+right)/2;
        int leftcount = merge(array,copy,left,mid)%1000000007;
        int rightcount = merge(array,copy,mid+1,right)%1000000007;
        int count =0;
        int temp=left;
        int left_index=left;
        int right_index = mid+1;
        while (left_index<=mid&&right_index<=right){
            if(array[left_index]>array[right_index]){
                copy[temp++] = array[right_index++];
                count+= (mid-left_index+1);
                if(count>=1000000007)//数值过大求余
                {
                    count%=1000000007;
                }
            }
            else {
                copy[temp++] = array[left_index++];
            }
        }
        while (left_index<=mid){
            copy[temp++]=array[left_index++];
        }
        while (right_index<=right){
            copy[temp++] =array[right_index++];
        }
        for(int s=left;s<=right;s++)
        {
            array[s] = copy[s];
        }

        return (leftcount+rightcount+count)%1000000007;
    }

    public static void main(String[] args) {
        int[] a = {7,6,5,4,3,2,1};
        System.out.println(new Ans_51().InversePairs(a));
        System.out.println(21%1000000007);
    }
}
