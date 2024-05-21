package classloader.arthas;


import classloader.Student;

import java.io.IOException;

/**
 * 使用工具查看类加载器
 */
public class Demo1 {
    public static void main(String[] args) throws IOException {
        Student student = new Student();
        System.out.println(student);

        System.in.read();
    }
}
