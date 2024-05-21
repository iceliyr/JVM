package q5reference;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

//-Xmx10m -verbose:gc
public class SoftReferenceDemo {
    private static int _1MB = 1024 * 1024 * 1;
    public static void main(String[] args) {
        List<SoftReference> objects = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            byte[] bytes = new byte[_1MB];
            //软引用
            SoftReference<byte[]> softReferences = new SoftReference<byte[]>(bytes);
            //软引用对象放入集合中
            objects.add(softReferences);

            System.out.println(i);
        }

        //有一部分对象因为内存不足，已经被回收了
        for (SoftReference softReference : objects) {
            System.out.println(softReference.get());
        }

    }
}
