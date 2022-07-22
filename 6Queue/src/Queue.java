/**
 * @author wangfan
 * @version 1.0.0
 * @date 2022/7/5 14:09
 * @description TODO
 */
public interface Queue<T> {
    int getSize();
    boolean isEmpty();
    void enqueue(T e);
    T dequeue();
    T getFront();
}
