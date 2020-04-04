package offer;

/**
 * Created by xiangchao on 2020/2/11.
 */
public class Ans_17 {
    public void printToMaxOfDigits(int n){
       if(n<=0){
           System.out.println("输入无意义");
           return;
       }
        char[] number = new char[n];
        for(int i=0;i<n;i++){
            number[i] = '0';
        }
        while (!incrementNumber(number)){
            printNumber(number);
        }
    }
    private boolean incrementNumber(char[] number) {
        boolean isOverFlow = false;
        int nTakeover = 0;
        int length = number.length;
        for(int i=length-1;i>=0;i--){
            int nSum = number[i] - '0' + nTakeover;
            if(i==length-1){
                nSum++;
            }
            if(nSum>=10){
                if(i==0){
                    isOverFlow=true;
                    return isOverFlow;
                }
                nSum-=10;
                nTakeover=1;
                number[i] = '0';
            }
            else {
                number[i] = (char)(nSum+'0');
                break;
            }
        }
        return isOverFlow;
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
        Ans_17 m1 = new Ans_17();
        m1.printToMaxOfDigits(0);
//        m1.printToMaxOfDigits(100);
    }

}
