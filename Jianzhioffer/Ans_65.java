package offer;

/**
 * Created by xiangchao on 2020/4/9.
 */
public class Ans_65 {
    public int Add(int num1,int num2) {
        while(num2!=0){
            int sum=num1^num2;
            int carry=(num1&num2)<<1;
            num1=sum;
            num2=carry;
        }
        return num1;
    }
}
