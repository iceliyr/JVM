package oop1;

import org.openjdk.jol.info.ClassLayout;

import java.io.IOException;
//-XX:-UseCompressedOops 关闭压缩指针
public class Student {
    private long id;
    private int age;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) throws IOException {
        Student student = new Student();
        System.out.println(Integer.toBinaryString(student.hashCode()));
        System.out.println(ClassLayout.parseInstance(student).toPrintable());
        System.in.read();
    }
}
//0010011 01011111 10111010 10100100
//  0x26163608