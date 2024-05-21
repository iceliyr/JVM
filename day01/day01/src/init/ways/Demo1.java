package init.ways;

/**
 * 初始化1 - 访问静态变量
 */
public class Demo1 {
    public static void main(String[] args) {
        int i = Demo2.i;
        System.out.println(i);
    }
}


class Demo2{
    static {
        System.out.println("初始化了...");
    }
    public static final int i = 0;
}