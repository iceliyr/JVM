package q5reference;

import java.util.ArrayList;
import java.util.List;

//-Xmx10m -verbose:gc
public class StrongReferenceDemo {
    private static int _1MB = 1024 * 1024 * 1;
    public static void main(String[] args) {
        List<Object> objects = new ArrayList<>();

        while (true){
            byte[] bytes = new byte[_1MB];
            //强引用
            objects.add(bytes);
        }

    }
}
