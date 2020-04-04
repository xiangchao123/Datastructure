package offer;

/**
 * Created by xiangchao on 2020/3/28.
 */
public class Ans_58_2 {
    public String LeftRotateString(String str,int n) {
        if(str==null||str.length()<n){
            return "";
        }
        char[] c =str.toCharArray();
        reverse(c,0,n-1);
        reverse(c,n,str.length()-1);
        reverse(c,0,str.length()-1);
        StringBuilder stringBuilder = new StringBuilder();
        for(char c1:c)
            stringBuilder.append(c1);
        return stringBuilder.toString();
    }
    public void reverse(char[] c,int low,int high){
        while (low<high){
            char temp = c[low];
            c[low] = c[high];
            c[high] = temp;
            low++;
            high--;
        }
    }
}
