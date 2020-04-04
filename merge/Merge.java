package merge;

/**
 * Created by xiangchao on 2020/3/19.
 */
public class Merge {
    public void sort(int[] data,int left,int right){
        if(data.length==0){
            return;
        }
        if(left==right){
            return;
        }
        int mid=(left+right)/2;
        sort(data,left,mid);
        sort(data,mid+1,right);
        merge(data,left,mid,right);
    }
    public void merge(int[] data,int left,int mid,int right){
        int[] temarr = new int[right-left+1];
        int temp=0;
        int temp_index=0;
        int right_index = mid+1;
        int left_index = left;
        while (left_index<=mid&&right_index<=right){
            if(data[left_index]<=data[right_index]){
                temarr[temp++]=data[left_index++];
            }
            else {
                temarr[temp++]=data[right_index++];
            }
        }
        while (left_index<=mid){
            temarr[temp++]=data[left_index++];
        }
        while (right_index<=right){
            temarr[temp++]=data[right_index++];
        }
        while (left<=right){
            data[left++] = temarr[temp_index++];
        }
    }

    public static void main(String[] args) {
        int[] a ={3,2,1,3,2,1};
        new Merge().sort(a,0,a.length-1);
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
}
