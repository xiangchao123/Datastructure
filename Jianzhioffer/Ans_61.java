package offer;

import java.util.Arrays;

/**
 * Created by xiangchao on 2020/4/9.
 */
public class Ans_61 {
    public boolean isContinuous(int [] numbers) {
        if(numbers==null||numbers.length<5){
            return false;
        }
        Arrays.sort(numbers);
        int numof0=0;
        for(int i=0;i<=numbers.length-1;i++){
            if(numbers[i]==0)
                numof0++;
        }
        int small=numof0;
        int big=numof0+1;
        int numofGap=0;
        while (big<numbers.length){
            if(numbers[small]==numbers[big])
                return false;
            numofGap+=numbers[big++]-numbers[small++]-1;
        }
        if(numofGap>numof0){
            return false;
        }
        return true;
    }
}
