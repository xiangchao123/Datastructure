package offer;

/**
 * Created by xiangchao on 2020/2/12.
 */
public class Ans_17_2 {
    public void printToMaxOfDigits(int n){
        if(n<=0){
            System.out.println("输入无意义");
            return;
        }
        char[] number = new char[n];
        for(int i =0;i<n;i++){
            number[i] = '0';
        }
        for(int i =0;i<10;i++){
            number[0] = (char) (i+'0');
            PrintToMaxOfNDigitsRecursively(number,n,0);
        }
    }
    public void PrintToMaxOfNDigitsRecursively(char[] number,int length,int index){
        if(index==length-1){
            printNumber(number);
            return;
        }
        for(int i=0;i<10;i++){
            number[index+1]=(char)(i+'0');
            PrintToMaxOfNDigitsRecursively(number,length,index+1);
        }
    }
    private void printNumber(char[] number) {
        boolean isBeginning0 = true;
        for(int i=0;i<number.length;i++){
            if(isBeginning0&&number[i]!='0'){
                isBeginning0=false;
            }
            if(!isBeginning0){
                System.out.print(number[i]);
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Ans_17_2 m1 = new Ans_17_2();
        m1.printToMaxOfDigits(10);
//        m1.printToMaxOfDigits(100);
    }
}
