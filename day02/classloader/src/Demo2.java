import java.io.IOException;

public class Demo2 {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        //获取main方法所在类的类加载器，应用程序类加载器
        ClassLoader classLoader = Demo2.class.getClassLoader();
        System.out.println(classLoader);

        //使用应用程序类加载器加载 com.itheima.my.A
        Class<?> clazz = classLoader.loadClass("com.itheima.my.A");
        System.out.println(clazz.getClassLoader());

        Class<?> stringClazz = classLoader.loadClass("java.lang.String");
        System.out.println(stringClazz.getClassLoader());

    }
}
