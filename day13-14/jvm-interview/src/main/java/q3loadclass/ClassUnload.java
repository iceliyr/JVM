package q3loadclass;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

/**
 * 类的卸载
 * JDK9以下-XX:TraceClassUnloaing
 * JDK9以上-Xlog:class+unload=info
 */
public class ClassUnload {
    public static void main(String[] args) throws InterruptedException {

        try {
            ArrayList<Class<?>> classes = new ArrayList<>();
            ArrayList<URLClassLoader> loaders = new ArrayList<>();
            ArrayList<Object> objs = new ArrayList<>();
            while (true) {

                URLClassLoader loader = new URLClassLoader(
                        new URL[]{new URL("file:D:\\lib\\")});
                Class<?> clazz = loader.loadClass("com.itheima.my.A");
                Object o = clazz.newInstance();


//                objs.add(o);
//                 loader = null;
                 classes.add(clazz);
//                 loaders.add(loader);

                 System.gc();

            }


        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}