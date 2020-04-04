package offer;

/**
 * Created by xiangchao on 2020/2/7.
 */
public class Ans_13 {
    public int movingCount(int threshold, int rows, int cols)
    {
        if(threshold<0||rows<0||cols<0){
            return 0;
        }
        boolean[] visited = new boolean[rows*cols];
        int count = movingCountCore(threshold,0,rows,0,cols,visited);
        return count;
    }
    private int movingCountCore(int threshold,int row,int rows,int col,int cols,boolean[] visited){
        int count=0;
        if(check(threshold,row,rows,col,cols,visited)){
            visited[row*cols+col] = true;
            count = 1+movingCountCore(threshold, row-1, rows, col, cols, visited)
                    +movingCountCore(threshold, row+1, rows, col, cols, visited)
                    +movingCountCore(threshold, row, rows, col-1, cols, visited)
                    +movingCountCore(threshold, row, rows, col+1, cols, visited);
        }
        return count;
    }
    private boolean check(int threshold,int row,int rows,int col,int cols,boolean[] visited){
        if(row>=0&&row<rows&&col>=0&&col<cols&&(getNumber(row)+getNumber(col))<=threshold&&!visited[row*cols+col]){
            return true;
        }
        return false;
    }
    private int getNumber(int data){
        int sumnumber=0;
        while(data!=0){
            sumnumber += data%10;
            data /= 10;
        }
        return sumnumber;
    }

    public static void main(String[] args) {
        new Ans_13().movingCount(5,10,10);
    }
}
