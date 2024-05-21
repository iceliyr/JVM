package q4classloader;

import java.lang.reflect.Field;

public class ClassLoaderDebug {
    public static void main(String[] args) throws ClassNotFoundException {
        ItheimaClassLoader itheimaClassLoader = new ItheimaClassLoader();

        Class<?> clazz = itheimaClassLoader.loadClass("com.itheima.springbootclassfile.pojo.vo.UserVO");

    }
}
