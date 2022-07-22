/**
 * @author wangfan
 * @version 1.0.0
 * @date 2022/7/5 8:02
 * @description TODO
 */
public class Main {
    public static void main(String[] args) {
        Array array = new Array(20);
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        System.out.println(array);
    }
}
