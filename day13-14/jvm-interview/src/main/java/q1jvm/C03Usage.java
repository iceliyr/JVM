package q1jvm;

//-Xint 禁止JIT即时编译器优化
public class C03Usage {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        C03Usage test = new C03Usage();
        test.jitTest();

        long end = System.currentTimeMillis();
        System.out.println("执行耗时:" + (end - start) + "ms");
    }

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
}
