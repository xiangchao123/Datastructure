package offer;

/**
 * Created by xiangchao on 2020/3/18.
 */
public class Ans_46 {
    public int getTranslationCount(int count){
        if(count<0){
            return 0;
        }
        String str = String.valueOf(count);
        int len = str.length();
        int[] counts = new int[len];
        for(int i=len-1;i>=0;i--){
            if(i==len-1){
                counts[i]=1;
            }
            else {
                counts[i] = counts[i+1];
                if(cantran(str,i)){
                    if(i==len-2){
                        counts[i]+=1;
                    }
                    else {
                        counts[i]+=counts[i+2];
                    }
                }
            }
        }
        return counts[0];
    }
    public boolean cantran(String str,int i){
        int a = str.charAt(i)-'0';
        int b = str.charAt(i+1)-'0';
        int number = a*10+b;
        if(number>=10&&number<=25){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Ans_46().getTranslationCount(210));
    }
}
