package offer;

/**
 * Created by xiangchao on 2020/2/15.
 */
public class Ans_19 {
    public boolean match(char[] str, char[] pattern)
    {
        if(str==null||pattern==null){
            return false;
        }
        return matchCore(str,0,pattern,0);
    }
    private static boolean matchCore(char[] str,int i,char[] pattern,int p){
        if(str.length==i&&pattern.length==p){
            return true;
        }

        if(str.length!=i&&pattern.length==p){
            return false;
        }
        if(p+1<pattern.length&&pattern[p+1]=='*'){
            if(str.length!=i&&str[i]==pattern[p]||(pattern[p]=='.'&&str.length!=i)){

                return matchCore(str,i+1,pattern,p+2) ||
                        //ignore '*'
                        matchCore(str,i,pattern,p+2) ||
                        //stay current state
                        matchCore(str,i+1,pattern,p);
            }
            else {
                return matchCore(str,i,pattern,p+2);
            }
        }
        if(str.length!=i&&str[i]==pattern[p]||(pattern[p]=='.'&&str.length!=i)){
            return matchCore(str,i+1,pattern,p+1);
        }
        return false;

    }

    public static void main(String[] args) {
        char[] str={};
        char[] pattern = {'.'};
        new Ans_19().match(str,pattern);
    }
}
