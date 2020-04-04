package offer;

/**
 * Created by xiangchao on 2020/2/24.
 */
public class Ans_39_2 {
    public int MoreThanHalfNum_Solution(int [] array){
        if(array==null||array.length==0)
            return 0;

        int result = array[0];
        int times = 1;
        for(int i =1;i<array.length;i++){
            if(times==0){
                result = array[0];
                times = 1;
            }
            else if(result==array[i]){
                times++;
            }
            else {
                times--;
            }
        }
        int times2=0;
        for(int i=0;i<array.length;i++){
            if(array[i] == result)
                times2++;
        }
        if(times2*2<=array.length){
            return 0;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array ={1,2,3,2,2,2,5,4,2};
        new Ans_39_2().MoreThanHalfNum_Solution(array);
    }
}
