package offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by xiangchao on 2020/3/17.
 */
public class Ans_45 {
    public String PrintMinNumber(int [] numbers) {
        if(numbers==null||numbers.length==0){
            return "";
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for(int i=0;i<numbers.length;i++){
            arrayList.add(String.valueOf(numbers[i]));
        }
        Collections.sort(arrayList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String c1 = o1+o2;
                String c2 = o2+o1;
                return c1.compareTo(c2);
            }
        });
        StringBuilder stringBuilder = new StringBuilder();
        for(String string:arrayList){
            stringBuilder.append(string);
        }
        return stringBuilder.toString();
    }
}
