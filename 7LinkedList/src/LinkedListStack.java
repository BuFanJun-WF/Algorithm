/**
 * @author wangfan
 * @version 1.0.0
 * @date 2022/7/6 9:51
 * @description 使用链表实现栈
 */
public class LinkedListStack<T> implements Stack<T> {

    private LinkedList2<T> list;

    public LinkedListStack() {
        list = new LinkedList2<>();
    }


    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(T e) {
        list.addFirst(e);
    }

    @Override
    public T pop() {
        return list.removeFirst();
    }

    @Override
    public T peek() {
        return list.getFirst();
    }

    @Override
    public String toString() {
        return "LinkedListStack{" +
                "list=" + list +
                '}';
    }
}
