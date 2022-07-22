/**
 * @author wangfan
 * @version 1.0.0
 * @date 2022/7/5 20:58
 * @description 1381题，设计一个支持增量操作的栈
 *              用数组模拟栈
 */
public class CustomStack {

    int[] stack;
    int top;


    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        top = -1;
    }

    public void push(int x) {
        if (top != stack.length -1) {
            top++;
            stack[top] = x;
        }
    }

    public int pop() {
        if (top == -1) {
            return -1;
        }
        --top;
        return stack[top+1];
    }

    public void increment(int k, int val) {
        int limit = Math.min(k, top+1);
        for (int i = 0; i < limit; i++) {
            stack[i] += val;
        }
    }
}
