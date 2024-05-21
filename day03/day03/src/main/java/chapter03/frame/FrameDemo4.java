package chapter03.frame;


/**
 * 栈帧测试3
 */
public class FrameDemo4 {
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
