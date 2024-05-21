import jdk.nashorn.internal.runtime.ScriptEnvironment;

import java.io.IOException;

public class Demo3 {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
//        ClassLoader classLoader = Demo3.class.getClassLoader();
//        Class<?> clazz = classLoader.loadClass("com.itheima.my.B");
//
        Class.forName("com.itheima.my.B");
    }
}
