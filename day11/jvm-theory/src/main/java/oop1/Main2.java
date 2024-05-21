package oop1;

import org.openjdk.jol.info.ClassLayout;

public class Main2 {
    public static void main(String[] args) throws InterruptedException {
        Student student = new Student();
        System.out.println("对象创建后的布局：");
        System.out.println(ClassLayout.parseInstance(student).toPrintable());

        System.gc();
        System.out.println("垃圾回收之后的布局：");
        System.out.println(ClassLayout.parseInstance(student).toPrintable());

        synchronized (student) {
            System.out.println("同步代码快进入之后的布局：");
            System.out.println(ClassLayout.parseInstance(student).toPrintable());
        }

        for (int i = 0; i < 2; i++) {
            Thread thread = new Thread(()->{
                synchronized (student) {
                    System.out.println("两个线程竞争时的布局：");
                    System.out.println(ClassLayout.parseInstance(student).toPrintable());
                }
            });
            thread.start();
        }

        Thread.sleep(500);
        student.hashCode();
        System.out.println("hashCode方法调用之后的布局：");
        System.out.println(ClassLayout.parseInstance(student).toPrintable());
    }
}
