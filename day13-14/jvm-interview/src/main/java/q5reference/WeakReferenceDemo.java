package q5reference;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

//-Xmx100m -verbose:gc
public class WeakReferenceDemo {
    private static int _1MB = 1024 * 1024 * 1;
    public static void main(String[] args) {
        List<WeakReference<byte[]>> objects = new ArrayList<>();
        System.out.println("-------------------");
        for (int i = 0; i < 10; i++) {
            byte[] bytes = new byte[_1MB];
            //弱引用
            WeakReference<byte[]> weakReference = new WeakReference<byte[]>(bytes);
            //弱引用对象放入集合中
            objects.add(weakReference);
        }

        //设置一个强引用
        byte[] last = objects.get(9).get();

        //手动执行一次垃圾回收，弱引用对象只要没有强引用，就会被直接回收
        System.gc();
        System.out.println("-------------------");
        for (WeakReference softReference : objects) {
            System.out.println(softReference.get());
        }
    }
}
