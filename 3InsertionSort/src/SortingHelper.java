/**
 * @author wangfan
 * @version 1.0.0
 * @date 2022/7/4 16:45
 * @description 判断是否排序正确的工具类
 */
public class SortingHelper {

    private SortingHelper() {}

    public static <T extends Comparable<T>> boolean isSorted(T[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i-1].compareTo(arr[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static <T extends Comparable<T>> void sortTest(String sortName, T[] arr) {

        long startTime = System.nanoTime();

        if (sortName.equals("InsertionSort")) {
            InsertionSort.sort(arr);
        } else if (sortName.equals("InsertionSort2")) {
            InsertionSort.sort2(arr);
        }

        long endTime = System.nanoTime();
        double time = ((endTime-startTime)/1000000000.0);
        if (!SortingHelper.isSorted(arr)) {
            throw new RuntimeException(sortName + "failed");
        }
        System.out.println(time + "s" + ",n = " + arr.length);
    }
}
