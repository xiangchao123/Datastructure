package offer;

/**
 * Created by xiangchao on 2020/3/19.
 */
public class Ans_50_2 {
    //Insert one char from stringstream
    int[] count = new int[256];
    int index = 1;
    public void Insert(char ch)
    {
        if(count[ch]==0){
            count[ch] = index++;
        }
        else {
            count[ch] = -1;
        }

    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        int tem = Integer.MAX_VALUE;
        char ch='#';
        for(int i=0;i<256;i++){
            if(count[i]!=0&&count[i]!=-1&&count[i]<tem){
                tem=count[i];
                ch = (char) i;
            }
        }
        return ch;
    }
}
