package oop1;

import org.openjdk.jol.info.ClassLayout;

import java.io.IOException;

//-XX:-UseCompressedOops 关闭压缩指针
public class Main1 {
    public static void main(String[] args) throws InterruptedException, IOException {
        Student student = new Student();
        System.out.println(ClassLayout.parseInstance(student).toPrintable());

        System.in.read();
    }
}
