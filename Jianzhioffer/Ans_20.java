package offer;

/**
 * Created by xiangchao on 2020/2/16.
 */
public class Ans_20 {
    public boolean isNumeric(char[] str) {
        if(str==null || str.length==0){
            return false;
        }
        int[] index = {0};
        boolean numirc = scanInteger(str,index);
        if(index[0]<str.length&&str[index[0]]=='.'){
            index[0]++;
            numirc =  scanUnsignedInteger(str,index) || numirc;
        }
        if(index[0]<str.length&&(str[index[0]]=='e'||str[index[0]]=='E')){
            index[0]++;
            numirc = numirc&&scanInteger(str,index);
        }
        if(numirc&&index[0]==str.length){
            return true;
        }
        else {
            return false;
        }
    }

    boolean scanUnsignedInteger(char[] str,int[] index){
        int j=index[0];
        while (index[0]<str.length&&(str[index[0]]-'0'>=0&&str[index[0]]-'0'<=9)){
            index[0]++;
        }
        if (index[0] > j)
            return true;
        else
            return false;
    }
    boolean scanInteger(char[] str,int[] index){
        if(index[0]<str.length&&(str[index[0]]=='-'||str[index[0]]=='+')){
            index[0]++;
        }
        return scanUnsignedInteger(str,index);
    }

    public static void main(String[] args) {
        char[] str={'1','2','3','.','4','5','e','+','6'};
        new Ans_20().isNumeric(str);
    }
}
