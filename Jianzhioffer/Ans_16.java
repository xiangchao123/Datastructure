package offer;

/**
 * Created by xiangchao on 2020/2/11.
 */
public class Ans_16 {
    public double Power(double base, int exponent) {
        double result = 0.0;
        if(equal(base,0.0)&&exponent<0){
            try {
                throw new Exception("无意义");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if(exponent==0){
            return 1.0;
        }
        else if(exponent<0){
            result = powerWithExponent(1/base,-exponent);
        }
        else {
            result = powerWithExponent(base,exponent);
        }
        return result;
    }
    public boolean equal(double num1,double num2){
        if(Math.abs(num1-num2)<0.00001){
            return true;
        }
        else {
            return false;
        }
    }
    public double powerWithExponent(double base,int expoent){
        if(expoent==1){
            return base;
        }
        double result = powerWithExponent(base,expoent>>1);
        result *=result;
        if((expoent&0x1)==1){
            result *= base;
        }
        return result;
    }

    public static void main(String[] args) {
        char s = (char)(5+'0');
        System.out.println(s);
    }
}
