package offer;

/**
 * Created by xiangchao on 2020/3/17.
 */
public class Ans_44 {
    public int digitAtIndex(int index){
        if(index<0){
            return -1;
        }
        int digit = 1;
        while (true){
            int numbers = numberOfInteger(digit);
            if(index<numbers*digit){
                return getDigit(index,digit);
            }
            index-=numbers*digit;
            digit++;
        }
    }
    public int numberOfInteger(int digit){
        if(digit==1){
            return 10;
        }
        return (int)(9*Math.pow(10,digit-1));
    }
    public int getDigit(int index,int digit){
        int number = getFirstNumber(digit)+index/digit;//实际在（index/digit）+1个
        int indexfromRight = digit-index%digit;
        for(int i=1;i<indexfromRight;i++){
            number/=10;
        }
        return number%10;
    }
    public int getFirstNumber(int digit){
        if(digit==1){
            return 0;
        }
        return (int)(Math.pow(10,digit-1));
    }

    public static void main(String[] args) {
        System.out.println(new Ans_44().digitAtIndex(997));
    }
}
