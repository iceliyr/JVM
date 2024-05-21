package q7oom;

import java.util.ArrayList;
import java.util.List;

//-Xmx10m -verbose:gc
public class OOMDemo {
    private static int _1MB = 1024 * 1024 * 1;
    public static void main(String[] args) throws InterruptedException {
        List<Object> objects = new ArrayList<>();

        while (true){
            byte[] bytes = new byte[_1MB];
            //强引用
            objects.add(bytes);
            Thread.sleep(50);
        }

    }
}
