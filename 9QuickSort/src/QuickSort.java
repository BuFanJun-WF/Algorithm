import java.util.Random;

/**
 * @author wangfan
 * @version 1.0.0
 * @date 2022/7/19 23:02
 * @description 快速排序，也就相当与二分法
 */
public class QuickSort {

    private QuickSort() {}

    public static <T extends Comparable<T>> void sort(T[] arr) {
        // 优化三：为快速排序的随机化在外部传入一个随机数对象
        Random random = new Random();
        sort2(arr, 0, arr.length - 1, random);
        sort(arr, 0, arr.length - 1);
    }

    public static <T extends Comparable<T>> void sort(T[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        // 递归之前进行数据操作，在进行递归
        int p = partition(arr, l, r);
        sort(arr, l, p-1);
        sort(arr, p+1, r);
    }

    /**
     * 使用插入排序进行优化，当要进行快速排序的数组小到一定程度的时候，进行转变为插入排序
     * @param arr
     * @param l
     * @param r
     * @param <T>
     */
    public static <T extends Comparable<T>> void sort2(T[] arr, int l, int r) {
        if (r - l <= 15) {
            // 调用之前的插入排序
            InsertionSort.sort(arr, l, r);
            return;
        }

        // 递归之前进行数据操作，在进行递归
        int p = partition(arr, l, r);
        sort(arr, l, p-1);
        sort(arr, p+1, r);
    }

    public static <T extends Comparable<T>> void sort2(T[] arr, int l, int r, Random random) {
        if (r - l <= 15) {
            // 调用之前的插入排序
            InsertionSort.sort(arr, l, r);
            return;
        }

        // 递归之前进行数据操作，在进行递归
        int p = partition(arr, l, r);
        sort(arr, l, p-1);
        sort(arr, p+1, r);
    }


    public static <T extends Comparable<T>> int partition(T[] arr, int l, int r) {
        // arr[l+1...j] < v; arr[j+1...i] >= v
        // 取到开头游标
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            // 在小于0的情况下，就要进行交换
            if (arr[i].compareTo(arr[l]) < 0) {
                // 前面的小范围进行扩充
                j++;
                // 将两个数进行交换
                swaq(arr, i, j);
            }
        }
        swaq(arr, l, j);
        return j;
    }

    /**
     * 在进行遍历排序的时候，进行优化，就是将刚开始的取值进行随机化，避免数据一开始是有序的导致递归层数过大
     * @param arr
     * @param l
     * @param r
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> int partition2(T[] arr, int l, int r) {
        // 生成[l, r]之间的随机索引
        int p = l + (new Random()).nextInt(r - l +1);
        swaq(arr, l, p);
        // arr[l+1...j] < v; arr[j+1...i] >= v
        // 取到开头游标
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            // 在小于0的情况下，就要进行交换
            if (arr[i].compareTo(arr[l]) < 0) {
                // 前面的小范围进行扩充
                j++;
                // 将两个数进行交换
                swaq(arr, i, j);
            }
        }
        swaq(arr, l, j);
        return j;
    }

    /**
     * 在进行遍历排序的时候，进行优化，就是将刚开始的取值进行随机化，避免数据一开始是有序的导致递归层数过大
     * 对比上一个实现，在实现细节的小优化就是不要让随机类不断的生成
     * @param arr
     * @param l
     * @param r
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> int partition2(T[] arr, int l, int r, Random random) {
        // 生成[l, r]之间的随机索引
        int p = l + random.nextInt(r - l + 1);
        swaq(arr, l, p);
        // arr[l+1...j] < v; arr[j+1...i] >= v
        // 取到开头游标
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            // 在小于0的情况下，就要进行交换
            if (arr[i].compareTo(arr[l]) < 0) {
                // 前面的小范围进行扩充
                j++;
                // 将两个数进行交换
                swaq(arr, i, j);
            }
        }
        swaq(arr, l, j);
        return j;
    }

    private static <T> void swaq(T[] arr, int i, int j) {
        T t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
