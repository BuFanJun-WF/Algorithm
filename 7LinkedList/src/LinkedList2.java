/**
 * @author wangfan
 * @version 1.0.0
 * @date 2022/7/6 7:20
 * @description 使用虚拟头节点
 */
public class LinkedList2<T> {

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

    private Node dummyHead;
    private int size;

    public LinkedList2() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    /**
     * 获取链表中的元素个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 返回链表是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在链表头添加新的元素
     *
     * @param e 元素
     */
    public void addFirst(T e) {
        add(0, e);
    }

    /**
     * 在链表的index位置添加新的元素e
     *
     * @param index 要添加的索引的位置
     * @param e     新的元素
     */
    public void add(int index, T e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("索引非法");
        }

        // 标记当前的链表的头部
        Node prev = dummyHead;

        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        Node node = new Node(e);
        node.next = prev.next;
        prev.next = node;
        // prev.next = new Node(e, prev.next)

        size++;
    }

    public void add2(int index, T e) {
        dummyHead = add(dummyHead, index, e);
        size++;
    }

    // 在以node为头结点的链表的index位置插入元素e，递归算法
    private Node add(Node node, int index, T e) {
        if (index == 0) {
            return new Node(e, node);
        }
        node.next = add(node.next, index - 1, e);
        return node;
    }

    public void addLast(T e) {
        add(size, e);
    }


    /**
     * 获取索引的元素
     * @param index
     * @return
     */
    public T get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("索引非法");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.data;
    }


    public T getFirst() {
        return get(0);
    }

    public T getLast() {
        return get(size - 1);
    }

    /**
     * 修改索引的元素
     * @param index
     * @return
     */
    public void set(int index, T e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("索引非法");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.data = e;
    }

    /**
     * 查找元素是否含有元素e
     * @param e
     * @return
     */
    public boolean contains(T e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.data.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 删除操作
     * @param index
     * @return
     */
    public T delete(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("索引非法");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;

        size--;

        return retNode.data;
    }

    public T removeFirst() {
      return delete(0);
    }

    public T removeLast() {
        return delete(size - 1);
    }

    @Override
    public String toString() {
        return "LinkedList2{" +
                "dummyHead=" + dummyHead +
                ", size=" + size +
                '}';
    }
}
