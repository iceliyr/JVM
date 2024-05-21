package init.ways;

public class Demo5 {
    static {
        System.out.println("Demo5初始化了...");
    }
    public static void main(String[] args) throws ClassNotFoundException {
        new Demo6();
    }
}


class Demo6{
    static {
        System.out.println("Demo6初始化了...");
    }
}