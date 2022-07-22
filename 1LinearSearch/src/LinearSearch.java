/**
 * @author wangfan
 * @version 1.0.0
 * @date 2022/7/3 23:05
 * @description 进行线性查找
 */
public class LinearSearch {

    /**
    public int  search(int[] data, int target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) {
                return i;
            }
        }
        return -1;
    }
    */

    // 将方法定义为泛型方法，指定T是未知数据类型
    public <T> int  search(T[] data, T target) {
        for (int i = 0; i < data.length; i++) {
            // 因为现在是一个对象，要判断的是值相等，所以要使用equals
            if (data[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        //int[] data = {24, 18, 12, 9};
        //Integer[] data = {24, 18, 12, 9};
        // 使用创建类
        int n = 10000000;
        Integer[] data = ArrayGenerator.generateOrderedArray(n);
        LinearSearch linearSearch = new LinearSearch();

        long startTime = System.nanoTime();
        // 泛型应该传入类对象而不是基本数据类型，因此，基本的数据类型应该使用对应的包装类
        int search = linearSearch.search(data, n);
        System.out.println(search);
        long endTime = System.nanoTime();
        double time = ((endTime-startTime)/1000000000.0);
        System.out.println(time + "s");

        int search1 = linearSearch.search(data, 1);
        System.out.println(search1);

        // 使用自定义对象类
        Student[] students = new Student[]{
                new Student("wangfan"),
                new Student("manyu"),
        };
        Student wangfan = new Student("wangfan");
        int search2 = linearSearch.search(students, wangfan);
        System.out.println(search2);
    }


}
