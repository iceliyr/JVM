package q7oom;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

//-Xmx10m -verbose:gc
public class OOMDemo2 {
    private static int _1MB = 1024 * 1024 * 1;
    public static void main(String[] args) throws InterruptedException {
        List<SoftReference> objects = new ArrayList<>();

        while (true) {
            byte[] bytes = new byte[_1MB];
            //软引用
            SoftReference<byte[]> softReferences = new SoftReference<byte[]>(bytes);
            //软引用对象放入集合中
            objects.add(softReferences);

            Thread.sleep(10);
        }
    }

}
