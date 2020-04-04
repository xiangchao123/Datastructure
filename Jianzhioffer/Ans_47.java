package offer;

/**
 * Created by xiangchao on 2020/3/18.
 */
public class Ans_47 {
    public int getMaxValue(int[][] ary){
        if(ary==null||ary.length==0){
            return 0;
        }
        int rows = ary.length;
        int cols = ary[0].length;
        int[] maxvalue = new int[cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                int left=0;
                int up=0;
                if(i>0)
                    up = maxvalue[j];
                if(j>0)
                    left = maxvalue[j-1];
                maxvalue[j] = Math.max(up,left)+ary[i][j];
            }
        }
        return maxvalue[cols-1];
    }
}
