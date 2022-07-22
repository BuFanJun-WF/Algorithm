/**
 * @author wangfan
 * @version 1.0.0
 * @date 2022/7/6 7:20
 * @description 没有虚拟头节点
 */
public class LinkedList<T>{

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

    private Node head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    /** 获取链表中的元素个数 */
    public int getSize() {
        return size;
    }

    /** 返回链表是否为空 */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在链表头添加新的元素
     * @param e 元素
     */
    public void addFirst(T e) {
        // Node node = new Node(e);
        // node.next = head;
        // head = node;

        head = new Node(e, head);
        size++;
    }

    /**
     * 在链表的index位置添加新的元素e
     * @param index 要添加的索引的位置
     * @param e 新的元素
     */
    public void add(int index, T e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("索引非法");
        }

        if (index == 0) {
            addFirst(e);
        } else {
            Node prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            Node node = new Node(e);
            node.next = prev.next;
            prev.next = node;

            // prev.next = new Node(e, prev.next)
            size++;
        }
    }

    public void addLast(T e) {
        add(size, e);
    }

}
