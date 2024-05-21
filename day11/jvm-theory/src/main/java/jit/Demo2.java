package jit;

import java.util.Random;

public class Demo2 {
    //-verbose:gc -Xmx10m -Xint
    public static void main(String[] args) {
        Random random = new Random();
        int count = 0;
        for (int i = 0; i < 10000000; i++) {
            Demo2Test d1 = new Demo2Test(random.nextInt(10));
            Demo2Test d2 = new Demo2Test(random.nextInt(10));
            if(d1.equals(d2)){
                count++;
            }
        }

    }
}

class Demo2Test{
    final int a;

    public Demo2Test(int a) {
        this.a = a;
    }

    @Override
    public boolean equals(Object o) {
        return this.a == ((Demo2Test)o).a;
    }

}