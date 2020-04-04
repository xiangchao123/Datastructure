package offer;

import java.util.Stack;

/**
 * Created by xiangchao on 2020/2/2.
 */
public class Ans_9 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {

        while (!stack2.empty()){
           return stack2.pop();
        }
        while (!stack1.empty()){
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
}