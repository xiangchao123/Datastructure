package offer;

/**
 * Created by xiangchao on 2020/3/18.
 */
public class Ans_49 {
    public int GetUglyNumber_Solution(int index) {
        if(index<=0){
            return 0;
        }
        int[] result = new int[index];
        result[0] = 1;
        int div2 = 0;
        int div3 = 0;
        int div5 = 0;
        for(int i=1;i<index;i++){
            int re2 = result[div2]*2;
            int re3 = result[div3]*3;
            int re5 = result[div5]*5;
            int min = Math.min(re2,Math.min(re3,re5));
            result[i] = min;
            if(re2 == result[i])
                div2++;
            if(re3 == result[i])
                div3++;
            if(re5 == result[i])
                div5++;
        }
        return result[index-1];

    }
}
