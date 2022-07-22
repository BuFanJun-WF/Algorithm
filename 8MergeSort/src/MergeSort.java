import java.util.Arrays;

/**
 * @author wangfan
 * @version 1.0.0
 * @date 2022/7/16 22:12
 * @description 归并排序
 *  具体思想是定义一个递归函数，对数组元素的[l,r]部分进行排序，然后不断压缩排序的[l,r]的范围，找到中间的部分进行分割成两个数组
 *  重点在于如何进行归并，就是像两个数组进行合并
 *
 *  归并过程：因为归并的时候两个有序的数组，所以直接比较两个数组中的最小的元素
 *  无法原地排序完成
 *
 *  转化成递归的方法，1.求解的最基本的问题
 *                2. 把原问题转化成更小的问题
 */
public class MergeSort {

    private MergeSort() {}

    public static <T extends Comparable<T>> void sort(T[] arr) {
        // 表示数组的开头，到结尾进行递归排序
        sort(arr, 0, arr.length - 1);

    }

    /**
     * 表示对arr[l,r]进行归并排序
     * @param arr
     * @param l
     * @param r
     * @param <T>
     */
    private static <T extends Comparable<T>> void sort(T[] arr, int l, int r) {
        // 递归的基本情况，没有或只有一个元素的时候不用进行排序
        if (l >= r) {
            return;
        }

        // 加法的写法可能会导致溢出
        //int mid = (l + r) / 2;

        // 所以要改成减法
        int mid = l + (r - l) / 2;
        // 对左边的数组进行归并排序
        sort(arr, l, mid);
        // 对右边的数组进行归并排序
        sort(arr, mid + 1, r);
        // 将左右两边排好序的数组进行合并,在递归到深层的时候是两个两个进行合并，就会自动排序
        merge(arr, l, r, mid);
    }

    /**
     * 合并两个有序的区间arr[l, mid] 和 arr[mid+1, r]
     * @param arr 进行合并的数组
     * @param l 左区间边界
     * @param r 右区间边界
     * @param mid 获取中间的分割线
     * @param <T> 进行类型泛化
     */
    private static <T extends Comparable<T>> void merge(T[] arr, int l, int r, int mid) {
        // 表示将arr[l,r+1)的数组复制到temp中
        T[] temp = Arrays.copyOfRange(arr, l, r+1);

        int i = l, j = mid + 1;

        // 每轮循环为arr[k]赋值，k从l出发
        for (int k = l; k <= r; k++) {

            // 说明i的索引走出了左边的区间，左边不再有元素了(左边取完了)
            if (i > mid) {
                arr[k] = temp[j - l];
                j++;
            }
            // 说明右边的所有元素都取完了
            else if (j > r) {
                arr[k] = temp[i - l];
                i++;
            }
            // 如果左边的元素比右边的元素小
            else if (temp[i -l].compareTo(temp[j - l]) <= 0) {
                arr[k] = temp[i -l];
                i++;
            } else {
                arr[k] = temp[j - l];
                j++;
            }

        }

    }


}
