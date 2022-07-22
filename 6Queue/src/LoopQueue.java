import java.util.Arrays;

/**
 * @author wangfan
 * @version 1.0.0
 * @date 2022/7/5 14:48
 * @description 循环队列,出队的比普通的出队会有很大的差异
 */
public class LoopQueue<T> implements Queue<T> {

    private T[] data;
    private int front, tail;
    private int size; // 元素数量

    public LoopQueue(int capacity) {
        data = (T[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;
    }


    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    /**
     * 入队
     * @param e
     */
    @Override
    public void enqueue(T e) {

        // 队列空间已满，就给主动扩容
        if ((tail + 1) % data.length == front) {
            resize(2 * getCapacity());
        }
        data[tail] = e;
        tail = (tail+1) % data.length;
        size++;
    }

    private void resize(int newCapacity) {
        T[] newData = (T[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i+front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    /**
     * 出队
     * @return
     */
    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("队伍为空");
        }

        // 先获取当前的队头元素
        T ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    /**
     * 获取队头
     * @return
     */
    @Override
    public T getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("队伍为空");
        }

        return data[front];
    }

    @Override
    public String toString() {
        return "LoopQueue{" +
                "data=" + Arrays.toString(data) +
                ", front=" + front +
                ", tail=" + tail +
                ", size=" + size +
                '}';
    }
}
