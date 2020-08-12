package sort;

/**
 * Created by xiangchao on 2020/8/12.
 */
public class InsertSort {
    public static void insertSort(int[] a,int n){
        int i,j,k;
        for(i=1;i<n;i++){
            for(j=i-1;j>=0;j--)
                if(a[j]<a[i])
                    break;
            if(j!=i-1){
                int temp = a[i];
                for(k=i-1;k>j;k--){
                    a[k+1] = a[k];
                }
                a[k+1] = temp;
            }
        }
    }


    public static void main(String[] args) {
        int i;
        int[] a = {20,40,30,10,60,50};

        System.out.printf("before sort:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");

        insertSort(a, a.length);

        System.out.printf("after  sort:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");
    }
}
