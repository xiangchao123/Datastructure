package offer;

/**
 * Created by xiangchao on 2020/2/5.
 */
public class Ans_10_3 {
    public int JumpFloorII(int target) {
        if(target==0){
            return 0;
        }
        return (int) Math.pow(2,target-1);
    }
}
