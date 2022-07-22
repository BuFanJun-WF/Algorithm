import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wangfan
 * @version 1.0.0
 * @date 2022/7/5 17:02
 * @description 用一个队列实现栈
 */
public class MyStack2 {
    Queue<Integer> queue;

    public MyStack2() {
        queue = new LinkedList<Integer>();
    }

    public void push(int x) {
        int n = queue.size();
        // 入队
        queue.offer(n);
        for (int i = 0; i < n; i++) {
            queue.offer(queue.poll());
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }

}
