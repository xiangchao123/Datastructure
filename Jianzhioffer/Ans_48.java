package offer;

/**
 * Created by xiangchao on 2020/3/18.
 */
public class Ans_48 {
    public int maxLength(String str){
        if(str==null||str.length()==0){
            return 0;
        }
        int curlen = 0;
        int maxlen = 0;
        int[] pos = new int[26];
        for(int i=0;i<26;i++){
            pos[i]-=1;
        }
        for(int i=0;i<str.length();i++){
            int letterindex = str.charAt(i)-'a';
            if(pos[letterindex]<0||i-pos[letterindex]>curlen){
                curlen++;
            }
            else {
                if(curlen>maxlen)
                    maxlen = curlen;
                curlen = i-pos[letterindex];
            }
            pos[letterindex] = i;
            if(curlen>maxlen)
                maxlen = curlen;
        }
        return maxlen;
    }

    public static void main(String[] args) {
        System.out.println(new Ans_48().maxLength("qwertmtghjlk"));
    }
}
