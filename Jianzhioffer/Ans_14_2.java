package offer;

/**
 * Created by xiangchao on 2020/2/7.
 */
public class Ans_14_2 {
    public int cutRope(int target){
        if(target<2){
            return 0;
        }
        if(target==2){
            return 1;
        }
        if(target==3){
            return 2;
        }
        int number_3 = target/3;
        if((target-3*number_3)==1){
            number_3-=1;
        }
        int number_2 = (target-3*number_3)/2;
        return (int)(Math.pow(3,number_3))*(int)(Math.pow(2,number_2));
    }
}
