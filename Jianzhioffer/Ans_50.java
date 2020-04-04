package offer;

/**
 * Created by xiangchao on 2020/3/19.
 */
public class Ans_50 {
    public int FirstNotRepeatingChar(String str) {
        if(str==null||str.trim().length()==0){
            return -1;
        }
        int[] count = new int[256];
        for(int i=0;i<str.length();i++){
            count[str.charAt(i)]++;
        }
        for(int i=0;i<str.length();i++){
            if(count[str.charAt(i)]==1){
                return i;
            }
        }
        return -1;
    }
}
