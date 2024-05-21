package chapter04.soft;

import java.io.IOException;
import java.lang.ref.SoftReference;

/**
 * 软引用案例2 - 基本使用
 */
public class SoftReferenceDemo2 {
    public static void main(String[] args) throws IOException {

        byte[] bytes = new byte[1024 * 1024 * 100];
        SoftReference<byte[]> softReference = new SoftReference<byte[]>(bytes);
        bytes = null;
        System.out.println(softReference.get());

        byte[] bytes2 = new byte[1024 * 1024 * 100];
        System.out.println(softReference.get());
//
        byte[] bytes3 = new byte[1024 * 1024 * 100];
        softReference = null;
//        System.gc();
//
//        System.in.read();
    }
}
