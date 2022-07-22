/**
 * @author wangfan
 * @version 1.0.0
 * @date 2022/7/5 9:55
 * @description TODO
 */
public class ArrayStack<T> implements Stack<T> {

    Array<T> array;

    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }
    public ArrayStack() {
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

    /**
     * 入栈
     * @param e
     */
    @Override
    public void push(T e) {
        array.addLast(e);
    }

    /**
     * 出栈
     * @return
     */
    @Override
    public T pop() {
        return array.removeLast();
    }

    /**
     * 查看栈顶元素
     * @return
     */
    @Override
    public T peek() {
        return array.getLast();
    }

    @Override
    public String toString() {
        return "ArrayStack{" +
                "array=" + array +
                '}';
    }
}
