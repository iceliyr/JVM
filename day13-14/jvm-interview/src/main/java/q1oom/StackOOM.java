package q1oom;


/**
 * -Xss180k 每个线程栈内存最大180k
 */
public class StackOOM {
    public static void main(String[] args) {
        recursion();
    }

    public static int count = 0;

    //递归方法调用自己
    public static void recursion() {
        long a,b,c,d,f,g,h,i,j,k;
        System.out.println(++count);
        recursion();
    }
}
