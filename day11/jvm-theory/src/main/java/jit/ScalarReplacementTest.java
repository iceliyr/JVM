package jit;

public class ScalarReplacementTest {
    public static void main(String[] args) {
        alloc();   
    }
    public static void alloc(){
        for (int i = 0; i < 1000000; i++) {
            //Point point = new Point();
            //point.test();
            int x = 1;
            int y = 2;
            int z = x++;
        }
    }
}
class Point{
    private int x;
    private int y;

    public void test(){
        x = 1;
        y = 2;
        int z = x++;
    }
}

