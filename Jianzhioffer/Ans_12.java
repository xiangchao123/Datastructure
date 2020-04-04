package offer;

/**
 * Created by xiangchao on 2020/2/6.
 */
public class Ans_12 {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        if(matrix==null||rows<1||cols<1||str==null){
            return false;
        }
        boolean[] visited = new boolean[rows*cols];
        int pathlength = 0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(hasPathcore(matrix,i,rows,j,cols,pathlength,visited,str)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean hasPathcore(char[] matrix, int row,int rows,int col,int cols,int pathlength,boolean[] visited,char[] str){
        if(row>=0&&row<rows&&col>=0&&col<cols&&matrix[row*cols+col]==str[pathlength]&&!visited[row*cols+col]){
            pathlength++;
            if(pathlength==str.length){
                return true;
            }
            visited[row*cols+col]=true;
            boolean haspath=false;
            haspath=hasPathcore(matrix, row-1, rows, col, cols, pathlength, visited, str)||
                    hasPathcore(matrix, row+1, rows, col, cols, pathlength, visited, str)||
                    hasPathcore(matrix, row, rows, col-1, cols, pathlength, visited, str)||
                    hasPathcore(matrix, row, rows, col+1, cols, pathlength, visited, str);
            if(!haspath){
                pathlength--;
                visited[row*cols+col]=false;
                return false;
            }
            return true;
        }
        return false;
    }
}
