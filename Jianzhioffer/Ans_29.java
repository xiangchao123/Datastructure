package offer;

import java.util.ArrayList;

/**
 * Created by xiangchao on 2020/2/20.
 */
public class Ans_29 {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        if(matrix==null||matrix.length<=0){
            return null;
        }
        if(matrix[0].length<=0){
            return null;
        }
        int start=0;
        int rows = matrix.length;
        int columns = matrix[0].length;
        ArrayList<Integer> arrayList = new ArrayList<>();
        while(rows>start*2&&columns>start*2){
            PrintMatrixInCircle(matrix,rows,columns,start,arrayList);
            start++;
        }
        return arrayList;
    }
    public void PrintMatrixInCircle(int[][] matrix,int rows,int columns,int start,ArrayList<Integer> arrayList){
        int endX = columns-1-start;
        int endY = rows-1-start;
        //从左向右打印
        for(int i=start;i<=endX;i++){
            arrayList.add(matrix[start][i]);
        }
        //从上向下打印
        if(endY>start){
            for(int i=start+1;i<=endY;i++){
                arrayList.add(matrix[i][endX]);
            }
        }
        //从右向左打印
        if(endY>start&&endX>start){
            for(int i=endX-1;i>=start;i--){
                arrayList.add(matrix[endY][i]);
            }
        }
        //从下向上打印
        if(endY-1>start&&endX>start){
            for(int i=endY-1;i>=start+1;i--){
                arrayList.add(matrix[i][start]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] mat = new int[0][2];
        System.out.println(mat.length);
    }
}
