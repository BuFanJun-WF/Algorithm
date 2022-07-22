/**
 * @author wangfan
 * @version 1.0.0
 * @date 2022/7/6 10:12
 * @description 使用链表实现队列，从head端删除元素，从tail端插入元素
 */
public class LinkedListQueue<T> implements Queue<T> {

    // 定义一个结点的内部类
    private class Node {
        public T data;
        public Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(T data) {
            this(data, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }

    private Node head, tail;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(T e) {
        // 当tail为空也就是队列为空
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("队列为空");
        }

        Node retNode = head;
        head = head.next;
        retNode.next = null;
        // 如果head为空，所以之前只有一个元素，也就是tail之前也是只向第一个元素，也是要进行清除
        if (head == null) {
            tail = null;
        }

        return retNode.data;
    }

    @Override
    public T getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("队列为空");
        }
        return head.data;
    }

    @Override
    public String toString() {
        return "LinkedListQueue{" +
                "head=" + head +
                ", tail=" + tail +
                ", size=" + size +
                '}';
    }
}
