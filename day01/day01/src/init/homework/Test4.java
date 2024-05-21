package init.homework;

/**
 * clinit初始化练习题2
 */
public class Test4 {
    public static void main(String[] args) {
        System.out.println(Test4_A.a);
    }
}

class Test4_A {
    public static final int a = Integer.valueOf(1);

    static {
        System.out.println("Test3_A的静态代码块运行");
    }
}
