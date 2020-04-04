package offer;

/**
 * Created by xiangchao on 2020/2/8.
 */
public class Ans_15 {
    public int NumberOf1(int n) {
        int count = 0;
        while (n!=0){
            count++;
            n=(n-1)&n;

        }
        return count;
    }
}
