import jdk.nashorn.internal.runtime.ScriptEnvironment;

import java.io.IOException;

public class Demo1 {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        Class<?> clazz = Class.forName("com.itheima.my.A");
        System.out.println(clazz);
        ClassLoader classLoader = clazz.getClassLoader();
        System.out.println(classLoader);

        ClassLoader classLoader1 = ScriptEnvironment.class.getClassLoader();
        System.out.println(classLoader1);

        System.in.read();
    }
}
