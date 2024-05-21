package q1oom;

import java.io.IOException;
import java.util.ArrayList;

//-Xmx10m
public class HeapOOM {
    public static void main(String[] args) throws InterruptedException, IOException {

        ArrayList<Object> objects = new ArrayList<Object>();
        while (true){
            objects.add(new byte[1024 * 1024 * 1]);
        }


    }
}
