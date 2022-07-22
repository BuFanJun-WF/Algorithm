import java.util.Arrays;

/**
 * @author wangfan
 * @version 1.0.0
 * @date 2022/7/4 23:35
 * @description 数组泛型类，在类上添加<T>
 *     均摊复杂度
 *     复杂度震荡：
 *          出现问题，removeLast时resize过于着急（eager）
 *          解决方案：Lazy，当size==capacity/4时，才将capacity减半
 */
public class Array<T> {

    private T[] data;
    private int size;

    /**
     * 构造函数，传入数组的容量capacity构造Array
     * @param capacity 数字容量
     */
    public Array(int capacity) {
        // 强制类型转化
        data = (T[]) new Object[capacity];
        size = 0;
    }

    /**
     * 无参数的构造函数，默认数组的容量capacity=10
     */
    public Array() {
        this(10);
    }

    //---------------------增加元素----------------
    /**
     * 向所有元素后添加一个新元素
     * @param e 新元素
     */
    public void addLast(T e) {
       add(size, e);
    }

    public void addFirst(T e) {
        add(0, e);
    }

    /**
     * 在第index个位置插入一个新元素
     * @param index 要插入的索引
     * @param e 插入元素
     */
    public void add(int index, T e) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed");
        }

        // 数组空间满了，要进行扩容
        if (size == data.length) {
            resize(2 * data.length);
        }


        // 元素向后移
        for (int i = size - 1; i >= index; i--) {
            data[i+1] = data[i];
        }
        data[index] = e;
        size ++;
    }

    /**
     * 进行扩容
     * @param newCapacity
     */
    private void resize(int newCapacity) {
        T[] newData = (T[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
    //---------------------增加元素----------------

    //---------------------查询元素----------------

    /**
     * 获取index索引位置的元素
     * @param index 索引位置
     * @return 索引位置的元素数据
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed");
        }
        return data[index];
    }

    public T getLast() {
        return get(size - 1);
    }

    public T getFirst() {
        return get(0);
    }

    /**
     * 查找数组中是否有元素e
     * @param e 查找的元素e
     * @return 返回是否存在
     */
    public boolean contains(T e) {
        for (T i :
                data) {
            if (i.equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
     * @param e 查找的元素
     * @return 返回元素的索引
     */
    public int find(T e) {
        int index = 0;
        for (T i :
                data) {
            if (i.equals(e)) {
                return index;
            }
            index++;
        }
        return -1;

    }

    //---------------------查询元素----------------

    //---------------------修改元素----------------
    /**
     * 修改index索引位置的元素
     * @param index 索引位置
     * @param e 元素内容
     */
    public void set(int index, T e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed");
        }
        data[index] = e;
    }
    //---------------------修改元素----------------

    //---------------------删除元素----------------

    /**
     * 从数组种删除index位置的元素，返回删除的元素
     * @param index 删除位置的索引
     * @return 返回删除的元素
     */
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed");
        }
        T ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i-1] = data[i];
        }
        size--;
        data[size] = null; // 清除数据

        // 数组动态减少
        //if (size == data.length / 2) {
        // 动态减少使用一个lazy的策略
        if (size == data.length / 4) {
            resize(data.length / 2);
        }
        return ret;
    }

    public T removeFirst() {
        return remove(0);
    }

    public T removeLast() {
        return remove(size - 1);
    }

    public void removeElement(T e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }
    //---------------------删除元素----------------


    public T[] getData() {
        return data;
    }

    public void setData(T[] data) {
        this.data = data;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int getCapacity() {
        return data.length;
    }

    @Override
    public String toString() {
        return "Array{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }
}
