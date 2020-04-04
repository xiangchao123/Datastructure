package offer;

/**
 * Created by xiangchao on 2020/2/5.
 */
public class Ans_10_2 {
    public int JumpFloor(int target) {
        if(target==0){
            return 0;
        }
        if(target==1){
            return 1;
        }
        if(target==2){
            return 2;
        }
        int fir =1;
        int sec =2;
        int result=0;
        for(int i=3;i<=target;i++){
            result = fir + sec;
            fir = sec;
            sec = result;
        }
        return result;
    }
}
