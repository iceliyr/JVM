package invokemethod;

import java.io.IOException;

public class InvokeMethod {

    public long test3(int a){
        System.out.println("invoke public method...");
        return 1L;
    }

    private long test2(int a){
        System.out.println("invoke private method...");
        return 1L;
    }

    public static void test1(){
        System.out.println("invoke static ...");
    }

    public static void main(String[] args) throws IOException {

        //invokestatic：调用静态方法
        test1();
        //invokespecial: 调用对象的private方法、构造方法，以及使用 super 关键字调用父类实例的方法、构造方法，以及所实现接口的默认方法。
        //new InvokeMethod().test2(1);
        //invokevirtual：调用对象的非私有方法。
        //new InvokeMethod().test3(1);
        //invokeinterface：调用接口对象的方法。
//        FlyWithWings fly = new FlyWithWings();
//        fly.fly();
        System.in.read();

    }
}
