import java.util.Deque;
import java.util.LinkedList;

/**
 * @author wangfan
 * @version 1.0.0
 * @date 2022/7/5 18:21
 * @description 获取栈中的最小值，这个空间复杂度为O(n)
 */
public class MinStack {

    Deque<Integer> xStack;
    Deque<Integer> minStack;

    public MinStack() {
        xStack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }

    /**
     * 入栈时用当前最小值与打算新入栈的进行对比
     * @param x
     */
    public void push(int x) {
        xStack.push(x);
        minStack.push(Math.min(minStack.peek(), x));
    }

    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

}
