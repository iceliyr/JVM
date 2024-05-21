package init.parent;

public class Demo01 {
    public static void main(String[] args) {
        System.out.println(A02.a);
    }
}

class A02{
    static int a = 0;
    static {
        a = 1;
    }
}

class B02 extends A02{
    static {
        a = 2;
    }
}