package offer;

/**
 * Created by xiangchao on 2020/3/28.
 */
public class Ans_58_1 {
    public String ReverseSentence(String str) {
        if(str==null||str.length()==0){
            return "";
        }
        char[] c = str.toCharArray();
        reverse(c,0,str.length()-1);
        int low=0;
        int high=0;
        while (low!=c.length){
           if(c[low]==' '){
               low++;
               high++;
           }
            else if(high==c.length||c[high]==' '){
               reverse(c,low,high-1);
               low=high;
           }
            else {
               high++;
           }

        }
        StringBuilder stringBuilder = new StringBuilder();
        for(char c1:c){
            stringBuilder.append(c1);
        }
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

    public static void main(String[] args) {
        String str="I am a student.";
        new Ans_58_1().ReverseSentence(str);
    }
}
