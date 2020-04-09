package offer;

/**
 * Created by xiangchao on 2020/3/29.
 */
public class Ans_60 {
    private static final int MAXVALUE = 6;
    public static void printProbability1(int number){
        if(number<1){
            return;
        }
        int[] prob = new int[MAXVALUE*number-number+1];
        for(int i=0;i<prob.length;i++){
            prob[i]=0;
        }
        for(int i=1;i<=MAXVALUE;i++){
            calP(prob,number,number-1,i);
        }
        int totalp = (int) Math.pow(MAXVALUE,number);
        for(int i=0;i<prob.length;i++){
            double ratio = (double) prob[i]/totalp;
            System.out.println((i+number)+"概率为："+ratio);
        }
    }
    private static void calP(int[] prob,int numer,int curnumer,int sum){
        if(curnumer==0){
            prob[sum-numer]++;
            return;
        }
        for(int i=1;i<=MAXVALUE;i++){
            calP(prob,numer,curnumer-1,sum+i);
        }
    }
    private static void printProbability2(int number){
        if(number<1){
            return;
        }
        int[][] prob = new int[2][number*MAXVALUE+1];
        for(int i=0;i<2;i++){
            for(int j=0;j<number*MAXVALUE+1;j++){
                prob[i][j]=0;
            }
        }
        for(int i=1;i<=6;i++){
            prob[0][i]=1;
        }
        int flag=0;
        for(int curnumer=2;curnumer<=number;curnumer++){
            for(int i=0;i<curnumer;i++){
                prob[1-flag][i]=0;//清零的目的是此时最小值从curnumber开始，清除小于curnumber的值
            }
           for(int i=curnumer;i<=curnumer*MAXVALUE;i++){
               for(int j=1;j<=6&&j<=i;j++){
                   prob[1-flag][i] += prob[flag][i-j];
               }
           }
            flag=1-flag;
        }
        int totalp =(int) Math.pow(MAXVALUE,number);
        for(int i=number;i<=number*6;i++){
            double ratio = (double) prob[flag][i]/totalp;
            System.out.println((i)+"概率为"+ratio);
        }

    }
}
