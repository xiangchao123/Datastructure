package offer;

/**
 * Created by xiangchao on 2020/1/30.
 */
public class Ans_5 {
    public String replaceSpace(StringBuffer str) {
        int numblock=0;
        int j = str.length()-1;
        for(int i=0;i<=j;i++){
            if(str.charAt(i)==' '){
                numblock++;
            }
        }
        int newlength = str.length()+2*numblock;
        str.setLength(newlength);
        int i = newlength-1;
        while (i>=0&&j>=0&&i>=j){
            if(str.charAt(j)==' '){
                str.setCharAt(i--,'0');
                str.setCharAt(i--,'2');
                str.setCharAt(i--,'%');
            }
            else {
                str.setCharAt(i--,str.charAt(j));
            }
            j--;
        }
        return str.toString();
    }
}
