package init.homework;

/**
 * clinit初始化练习题1
 */
public class Test2 {
    public static void main(String[] args) {
        Test2_A[] arr = new Test2_A[10];
    }
}

class Test2_A {
    static {
        System.out.println("Test2_A的静态代码块运行");
    }
}
