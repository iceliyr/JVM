package chapter03.frame;


/**
 * 栈帧测试2
 */
public class FrameDemo3_2 {
    public static void main(String[] args) {
        FrameDemo3_2 demo = new FrameDemo3_2();
        demo.A();
    }

    public int calc(){
        int a = 100;
        int b = 200;
        int c = 300;
        return (a+b)*c;
    }

    public void A() {
        {
            int kkkk = 0;
            long t = 1;
            int n = 2;
        }
        {
            int bbbb = 0;
        }
        long j = 112222222222222222L;
        double kkk2 = 1.1;
        B();
    }

    public void B() {
        C();
    }

    public void C() {
    }

}
