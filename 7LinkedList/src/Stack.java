/**
 * @author wangfan
 * @version 1.0.0
 * @date 2022/7/5 9:53
 * @description TODO
 */
public interface Stack<T> {

    int getSize();
    boolean isEmpty();

    /**
     * 入栈
     * @param e
     */
    void push(T e);

    /**
     * 出栈
     * @return
     */
    T pop();

    /**
     * 查看栈顶元素
     * @return
     */
    T peek();
}
