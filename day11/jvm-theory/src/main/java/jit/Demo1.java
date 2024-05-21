package jit;

//JIT Watch测试代码
public class Demo1 {
    public int add (int a,int b){
        return a + b;
    }

    public int jitTest(){
        int sum = 0;
        for (int i = 0; i < 10000000; i++) {
            sum = add(sum,100);
        }
        return sum;
    }
    public static void main(String[] args) {
        new Demo1().jitTest();
    }
}
