package init;

public class Demo2 {
    //    static{
//        System.out.println("123");
//    }
    public static int i = 10;
    public static void main(String[] args) {
        int a=1;
        a=(a++)*(a++);
        System.out.println(a);
    }
}