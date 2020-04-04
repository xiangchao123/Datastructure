package offer;

import java.util.Stack;

/**
 * Created by xiangchao on 2020/2/20.
 */
public class Ans_31 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        boolean isPoporder = false;
        if(pushA==null||popA==null){
            return isPoporder;
        }
        Stack<Integer> stack =new Stack<>();
        int popindex=0;
        for(int i=0;i<pushA.length;i++){
            stack.push(pushA[i]);
            while (!stack.isEmpty()&&stack.peek()==popA[popindex]){
                stack.pop();
                popindex++;
            }
        }
        if(stack.isEmpty()&&popA.length==popindex){
            isPoporder=true;
        }
        return isPoporder;
    }
}
