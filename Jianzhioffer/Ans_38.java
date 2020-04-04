package offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by xiangchao on 2020/2/23.
 */
public class Ans_38 {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        if(str!=null||str.length()>0){
            findstr(0,str.toCharArray(),arrayList);
            Collections.sort(arrayList);
        }
        return arrayList;
    }
    public void findstr(int begin,char[] chars,ArrayList<String> arrayList){
        if(begin==chars.length-1){
            String string = String.valueOf(chars);
            if(!arrayList.contains(string)){
                arrayList.add(string);
            }

        }
        else {
            for(int i = begin;i<chars.length;i++){
                swap(chars,i,begin);
                findstr(begin+1,chars,arrayList);
                swap(chars,i,begin);
            }
        }
    }
    public void swap(char[] chars ,int i,int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        char[] c = {'a','b','c'};
        new Ans_38().swap(c,0,1);
        Arrays.asList(c).forEach(System.out::println);

    }
}
