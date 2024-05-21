package q5reference;

import java.util.ArrayList;

//-verbose:gc
public class ThreadLocalDemo2 {

    public static ThreadLocal<Object> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {

        threadLocal.set(new byte[1024 * 1024 * 100]);
        ArrayList<ThreadLocal> objects = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            ThreadLocal<Object> objectThreadLocal = new ThreadLocal<>();
            objectThreadLocal.set(new byte[1]);
            objects.add(objectThreadLocal);
        }

        threadLocal.remove();
        threadLocal = null;
        for (ThreadLocal obj : objects) {
            obj.set(new byte[1]);
        }

        System.gc();



    }
}
