package offer;

/**
 * Created by xiangchao on 2020/1/28.
 */
public class Ans_3 {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers==null||length<0){
            return false;
        }
        for(int i=0;i<length;i++){
            if(numbers[i]<0||numbers[i]>=length){

                return false;
            }
        }
        int temp;
        for(int i=0;i<length;i++){
            while (numbers[i]!=i) {
                if(numbers[i]==numbers[numbers[i]]){
                    duplication[0]=numbers[i];
                    return true;
                }
                temp = numbers[i];
                numbers[i] = numbers[temp];
                numbers[temp] = temp;
            }
        }

        return false;
    }
}
