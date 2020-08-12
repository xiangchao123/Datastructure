package sort;

/**
 * Created by xiangchao on 2020/8/12.
 */
public class HeapSort {
    public static void heapSortAsc(int[] a,int n){
        int i,tmp;
        for(i=n/2-1;i>=0;i--){
            maxHeapDown(a,i,n-1);
        }
        for(i=n-1;i>0;i--){
            tmp = a[0];
            a[0] = a[i];
            a[i] = tmp;
            maxHeapDown(a,0,i-1);
        }
    }

    private static void maxHeapDown(int[] a, int start, int end) {
        int cur = start;
        int l = cur*2+1;
        int temp = a[cur];
        for(;l<=end;cur=l,l=2*l+1){
            if(l<end&&a[l]<a[l+1]) l++;
            if(temp>a[l]) break;
            else {
                a[cur] = a[l];
                a[l] = temp;
            }
        }
    }



    public static void main(String[] args) {
        int i;
        int a[] = {20,30,90,40,70,110,60,10,100,50,80};

        System.out.printf("before sort:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");

        heapSortAsc(a, a.length);            // 升序排列
        //heapSortDesc(a, a.length);        // 降序排列

        System.out.printf("after  sort:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");
    }
}
