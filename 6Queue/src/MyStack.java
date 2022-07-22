import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wangfan
 * @version 1.0.0
 * @date 2022/7/5 16:14
 * @description 利用两个队列实现栈的功能
 *
 * add         增加一个元索                      如果队列已满，则抛出一个IIIegaISlabEepeplian异常
 * remove   移除并返回队列头部的元素     如果队列为空，则抛出一个NoSuchElementException异常
 * element  返回队列头部的元素              如果队列为空，则抛出一个NoSuchElementException异常
 *
 * offer       添加一个元素并返回true        如果队列已满，则返回false
 * poll         移除并返问队列头部的元素     如果队列为空，则返回null
 * peek       返回队列头部的元素              如果队列为空，则返回null
 */
public class MyStack {
    // queue1用于存储栈内元素
    Queue<Integer> queue1;
    // queue2用于入栈操作的辅助队列
    Queue<Integer> queue2;

    /**
     * 初始化
     */
    public MyStack() {
        queue1 = new LinkedList<Integer>();
        queue2 = new LinkedList<Integer>();
    }

    /**
     * 入栈
     * @param x 入栈元素
     */
    public void push(int x) {
        queue2.add(x);
        // 将队1的元素依次入队queue2
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        // 对象引用进行交换
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    /**
     * 出栈
     * @return 返回出栈元素
     */
    public int pop() {
        return queue1.poll();
    }

    /**
     * 返回栈顶元素
     * @return 栈顶元素
     */
    public int top() {
        return queue1.peek();
    }

    /**
     * 判断是否为空
     * @return
     */
    public boolean empty() {
        return queue1.isEmpty();
    }
}
