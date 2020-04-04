package offer;

import java.util.Stack;

/**
 * Created by xiangchao on 2020/2/20.
 */
public class Ans_30 {
    Stack<Integer> dataStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    public void push(int node) {
        dataStack.push(node);
        if(minStack.size()==0||node<minStack.peek()){
            minStack.push(node);
        }
        else {
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        if(minStack.size()>0&&dataStack.size()>0){
            dataStack.pop();
            minStack.pop();
        }

    }

    public int top() {
        if(dataStack.size()>0){
            return dataStack.peek();
        }
        return 0;
    }

    public int min() {
        if(minStack.size()>0){
            return minStack.peek();
        }
        return 0;
    }
}
