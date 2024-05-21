package oop1;

import org.openjdk.jol.info.ClassLayout;

public class Main3 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(ClassLayout.parseInstance(new C()).toPrintable());
        System.out.println(ClassLayout.parseInstance(new A()).toPrintable());
        System.out.println(ClassLayout.parseInstance(new B()).toPrintable());
    }
}
