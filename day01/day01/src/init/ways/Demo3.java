package init.ways;

/**
 * 初始化2 - Class.forName
 */
public class Demo3 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz = Class.forName("init.ways.Demo4");
    }
}


class Demo4{
    static {
        System.out.println("初始化了...");
    }
}