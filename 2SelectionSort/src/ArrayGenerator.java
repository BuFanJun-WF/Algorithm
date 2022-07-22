import java.util.Random;

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

    /**
     * 生成一个随机数组
     * @param n
     * @param bound
     * @return
     */
    public static Integer[] generateRandomArray(int n, int bound) {
        Integer[] arr = new Integer[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(bound);
        }
        return arr;
    }
}
