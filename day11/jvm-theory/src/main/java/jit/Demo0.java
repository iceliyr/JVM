package jit;

//JIT Watch测试代码
public class Demo0 {
    public int add (int a,int b){
        return a + b;
    }

    public int jitTest(){
        int a = 1,b = 2;
        int result = a + b;
        return result;

    }

    public static void main(String[] args) {
        new Demo0().jitTest();
    }
}
