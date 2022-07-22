/**
 * @author wangfan
 * @version 1.0.0
 * @date 2022/7/5 14:38
 * @description TODO
 */
public class ArrayQueue<T> implements Queue<T>{

    private Array<T> array;

    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayQueue() {
        array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public String toString() {
        return "ArrayQueue{" +
                "array=" + array +
                '}';
    }

    /**
     * 入队
     * @param e
     */
    @Override
    public void enqueue(T e) {
        array.addLast(e);
    }

    /**
     * 出队
     * @return
     */
    @Override
    public T dequeue() {
        return array.removeFirst();
    }

    /**
     * 显示队头元素
     * @return
     */
    @Override
    public T getFront() {
        return array.getFirst();
    }
}
