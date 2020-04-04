package offer;

/**
 * Created by xiangchao on 2020/2/7.
 */
public class Ans_14 {
    public int cutRope(int target) {
        if(target==0){
            return 0;
        }
        if(target==1){
            return 1;
        }
        if(target==2){
            return 1;
        }
        if(target==3){
            return 2;
        }
        int[] products = new int[target+1];
        products[0]=0;
        products[1]=1;
        products[2]=2;
        products[3]=3;
        for(int i=4;i<=target;i++){
            int max=0;
            for(int j=1;j<=i/2;j++){
                int product = products[j]*products[i-j];
                if(product>max){
                    max=product;
                }
                products[i] = max;
            }
        }
        return products[target];
    }
}
