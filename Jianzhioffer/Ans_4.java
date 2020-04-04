package offer;

/**
 * Created by xiangchao on 2020/1/30.
 */
public class Ans_4 {
    public boolean Find(int target, int [][] array) {
        if(array==null||array[0].length==0){
            return false;
        }
        int row = array.length-1;
        int column = array[0].length-1;
        for(int i=0;i<=row;i++){
            for(int j=column;j>=0;j--){
                if(target==array[i][j]){
                    return true;
                }
                else if(target<array[i][j])
                    continue;
                else
                    break;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int [][] array = new int[2][3];
        int row = array.length;
        int column = array[0].length;
        System.out.println(row);
        System.out.println(column);

    }
}
