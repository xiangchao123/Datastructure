package sort;

/**
 * Created by xiangchao on 2020/8/12.
 */
public class BubbleSort {
    public static void bubbleSort1(int[] a,int n){
        int i,j;
        for(i=n-1;i>0;i--){
            for(j=0;j<i;j++){
                if(a[j]>a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }
    public static void bubbleSort2(int[] a,int n){
        int i,j;
        boolean flag;
        for(i=n-1;i>0;i--){
            flag = false;
            for(j=0;j<i;j++){
                if(a[j]>a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    flag = true;
                }
            }
            if(!flag){
                break;
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

//        bubbleSort1(a, a.length);
        bubbleSort2(a, a.length);

        System.out.printf("after  sort:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");
    }
}
