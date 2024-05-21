package init;

/**
 * 查看字节码文件中的clinit字节码指令
 */
public class Demo01 {

    public static int a = 10;

    static {
        a = 20;
    }

    public static void main(String[] args) {
        System.out.println("Demo01");
    }
}
