package offer;

/**
 * Created by xiangchao on 2020/2/20.
 */
public class Ans_33 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence==null||sequence.length==0){
            return false;
        }
        return judge(sequence,0,sequence.length-1);
    }
    private boolean judge(int[] sequence,int start,int end){
        if(start>=end){
            return true;
        }
       int root = sequence[end];
        int i =start;
        for(;i<end;i++){
            if(sequence[i]>root){
                break;
            }
        }
        int j = i;
        for(;j<end;j++){
            if(sequence[j]<root){
                return false;
            }
        }
        return judge(sequence,start,i-1)&&judge(sequence,i,end-1);
    }
}
