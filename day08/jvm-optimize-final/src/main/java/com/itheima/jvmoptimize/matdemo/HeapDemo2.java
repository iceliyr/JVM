package com.itheima.jvmoptimize.matdemo;

import java.util.ArrayList;
import java.util.List;

//-XX:+HeapDumpBeforeFullGC -XX:HeapDumpPath=D:/jvm/heapdemo.hprof
public class HeapDemo2 {
    public static void main(String[] args) {
        TestClass2 a1 = new TestClass2();
        TestClass2 a2 = new TestClass2();
        TestClass2 a3 = new TestClass2();

        byte[] bytes1 = new byte[1024 * 1024  * 10];
        byte[] bytes2 = new byte[1024 * 1024  * 10];
        byte[] bytes3 = new byte[1024 * 1024  * 10];

        a1.list.add(bytes1);

        a2.list.add(bytes1);
        a2.list.add(bytes2);

        a3.list.add(bytes3);

        //System.out.print(ClassLayout.parseClass(TestClass.class).toPrintable());
        bytes1 = null;
        bytes2 = null;
        bytes3 = null;

        System.gc();
    }
}

class TestClass2 {
    public List<byte[]> list = new ArrayList<byte[]>(10);
}
