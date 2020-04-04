package offer;

/**
 * Created by xiangchao on 2020/2/16.
 */
public class Ans_21 {
    public void reOrderArray(int [] array) {
        reorder(array);
    }
    public void reorder(int[] array){
        if(array==null||array.length==0){
            return;
        }
        int pBegin = 0;
        int pEnd = array.length-1;
        while (pBegin<pEnd){
            while (pBegin<pEnd&&!func(array[pBegin]))
                pBegin++;
            while (pBegin<pEnd&&func(array[pEnd]))
                pEnd--;
            if(pBegin<pEnd){
                int temp = array[pBegin];
                array[pBegin] = array[pEnd];
                array[pEnd] = temp;
            }

        }
    }
    public boolean func(int n){
        return (n&1) == 0;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7};
        new Ans_21().reOrderArray(array);
        for(Integer integer:array){
            System.out.println(integer);
        }
    }
}
