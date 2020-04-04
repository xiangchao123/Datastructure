package offer;

/**
 * Created by xiangchao on 2020/3/27.
 */
public class Ans_56 {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
            if(array==null||array.length<2){
                return;
            }
            int xor=0;
            int flag=1;
            for(int i=0;i<array.length;i++){
                xor^=array[i];
            }
            while ((xor&flag)==0)
                flag<<=1;
            for(int i=0;i<array.length;i++){
                if((flag&array[i])==0)
                    num1[0]^=array[i];
                else
                    num2[0]^=array[i];
            }
    }

    public static void main(String[] args) {
        int i=0;
        i=i<<1;
        i+=2;
        i=i<<1;
        System.out.println(i );
    }
}
