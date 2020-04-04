package offer;

/**
 * Created by xiangchao on 2020/2/5.
 */
public class Ans_10 {
    public int Fibonacci(int n) {
        if(n<0){
            return -1;
        }
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        int pre=0;
        int suf=1;
        int result=0;
        for(int i=2;i<=n;i++){
            result = pre + suf;
            pre = suf;
            suf = result;
        }
        return result;
    }
}
