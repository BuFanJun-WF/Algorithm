/**
 * @author wangfan
 * @version 1.0.0
 * @date 2022/7/4 10:35
 * @description TODO
 */
public class ArrayGenerator {
    private ArrayGenerator() {}

    public static Integer[] generateOrderedArray(int n) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }
}
