/**
 * @author wangfan
 * @version 1.0.0
 * @date 2022/7/4 15:37
 * @description 选择排序
 *              其中使用泛型的话，应该使用一个有约束的泛型，也就是泛型T继承Comparable<E>这个接口
 */
public class SelectionSort {
    private SelectionSort() {}

    public static <T extends Comparable<T>> void sort(T[] arr) {

        // 其中arr[0..i)是有序的;arr[i...n)是无序的
        for (int i = 0; i < arr.length; i++) {
            // 作为最小值的游标
            int minIndex = i;
            // 选择arr[i...n)中的最小值的索引
            for (int j = i; j < arr.length; j++) {
                // 如果找到一个比当前最小值小的值的话，就进行替换
                /*
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
                */
                // 使用泛型比较的话，应该要实现一个compareTo()方法
                // compareTo()返回的一个整型，小于0表示前者小于后者，大于0表示前者大于后者
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            // 将i和minIndex两个位置交换
            swap(arr, i, minIndex);
        }

        // 其中arr[i...n)是有序的；arr[0..i)是无序的
        for (int i = arr.length; i > 0; i--) {
            // 选择arr[0...i]中的最大值
            int maxIndex = i;
            for (int j = i; j > 0; j--) {
                if (arr[j].compareTo(arr[maxIndex]) > 0) {
                    maxIndex = j;
                }
            }
            swap(arr, i, maxIndex);
        }
    }

    //数组交换
    private static <T> void swap(T[] arr, int i, int j) {

        T t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {

        //Integer[] arr = {5, 1, 24, 7, 8, 7};

        int[] dataSize = {10000, 100000};
        for (int n :
                dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            SortingHelper.sortTest("SelectionSort", arr);
        }


        /*
        Student[] students = {
                new Student("wangfan", 90),
                new Student("manyu",80),
        };
        SelectionSort.sort(students);
        for (Student a :
                students) {
            System.out.println(a.toString());
        }
        */
    }
}
