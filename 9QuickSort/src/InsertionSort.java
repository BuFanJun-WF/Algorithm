import java.util.Arrays;

/**
 * @author wangfan
 * @version 1.0.0
 * @date 2022/7/4 21:07
 * @description TODO
 */
public class InsertionSort {

    private InsertionSort() {}

    public static <T extends Comparable<T>> void sort(T[] arr) {
        for (int i = 0; i < arr.length; i++) {

            // 将arr[i]插入到合适的位置
            for (int j = i; j - 1 >= 0; j--) {
                // 如果后面的小于前面的，就进行位置交换
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    swap(arr, j, j-1);
                } else {
                    // 因为是从左向右排序，所以i位置上的数一定比前面的大，当i+1比i大时，说明i+1一定比前面的数大，不用比较直接break
                    break;
                }
            }

            // 进行代码简化，因为不满足arr[j].compareTo(arr[j - 1]) < 0也是终止循环，所以可以直接将这个判断加入到循环条件中
            //for (int j = i; j - 1 >= 0 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
            //    // 如果后面的小于前面的，就进行位置交换
            //    swap(arr, j, j-1);
            //}
        }
    }

    // 对插入排序法进行优化减少交换次数，而是改成一次赋值
    public static <T extends Comparable<T>> void sort2(T[] arr) {

        for (int i = 0; i < arr.length; i++) {
            // 将当前要交换的值记录下来
            T t = arr[i];
            int j;
            // 将arr[i]插入到合适的位置
            for (j = i; j - 1 >= 0; j--) {
                // 保证处理的位置时arr[i]
                if (t.compareTo(arr[j - 1]) < 0) {
                    // 左边的数向右平移一位
                    arr[j] = arr[j-1];
                } else {
                    // 因为是从左向右排序，所以i位置上的数一定比前面的大，当i+1比i大时，说明i+1一定比前面的数大，不用比较直接break
                    break;
                }
            }
            arr[j] = t;
        }
    }


    public static <T extends Comparable<T>> void sort(T[] arr, int l, int r) {

        for (int i = l; i < r; i++) {
            // 将当前要交换的值记录下来
            T t = arr[i];
            int j;
            // 将arr[i]插入到合适的位置
            for (j = i; j - 1 >= 0; j--) {
                // 保证处理的位置时arr[i]
                if (t.compareTo(arr[j - 1]) < 0) {
                    // 左边的数向右平移一位
                    arr[j] = arr[j-1];
                } else {
                    // 因为是从左向右排序，所以i位置上的数一定比前面的大，当i+1比i大时，说明i+1一定比前面的数大，不用比较直接break
                    break;
                }
            }
            arr[j] = t;
        }
    }


    //数组交换
    private static <T> void swap(T[] arr, int i, int j) {

        T t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

}
