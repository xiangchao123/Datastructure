package offer;

/**
 * Created by xiangchao on 2020/4/9.
 */
public class Ans_64 {
    public int Sum_Solution(int n) {
        int sum=n;
        boolean flag = (n>1)&&((sum+=Sum_Solution(n-1))>0);
        return sum;
    }

}
