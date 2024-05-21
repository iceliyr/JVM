package init.interview;

/**
 * 面试题2
 */
public class Demo02 {
    public static void main(String[] args) {
        new B02();
        System.out.println(B02.a);
    }
}

class A02 {
    static int a = 0;

    static {
        a = 1;
    }
}

class B02 extends A02 {
    static {
        a = 2;
    }
}
