/**
 * @author wangfan
 * @version 1.0.0
 * @date 2022/7/5 20:58
 * @description 1381题，设计一个支持增量操作的栈
 *              用数组模拟栈进行优化
 */
public class CustomStack2 {

    int[] stack;
    int[] add;
    int top;


    public CustomStack2(int maxSize) {
        stack = new int[maxSize];
        add = new int[maxSize];
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
        int ret = stack[top] + add[top];
        if (top != 0) {
            add[top - 1] += add[top];
        }
        add[top] = 0;
        --top;
        return ret;
    }

    public void increment(int k, int val) {
        int limit = Math.min(k-1, top);
        if (limit >= 0) {
            add[limit] += val;
        }
    }

    public static void main(String[] args) {
        CustomStack2 customStack2 = new CustomStack2(2);
        customStack2.push(1);
        customStack2.push(1);
        customStack2.increment(2, 100);
        customStack2.pop();
        customStack2.pop();
    }
}
