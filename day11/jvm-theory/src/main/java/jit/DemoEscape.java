package jit;

import java.util.Random;

public class DemoEscape {

    public static void main(String[] args) {

        for (int i = 0; i < 10000000; i++) {
            Test test = new Test();
            int t = testToMethod(test);

            synchronized (new Test()){

            }
        }

    }

    public static int testToMethod(Test test){
        return 0;
    }
}

class Test{
    int a;

}