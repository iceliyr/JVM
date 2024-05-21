package q1oom;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * -XX:MaxDirectMemorySize=50m
 */
public class DirectOOM {
    public static int size = 1024 * 1024 * 100; //100mb
    public static List<ByteBuffer> list = new ArrayList<ByteBuffer>();
    public static int count = 0;

    public static void main(String[] args) throws IOException, InterruptedException {
        while (true) {
            ByteBuffer directBuffer = ByteBuffer.allocateDirect(size);
            list.add(directBuffer);
        }

    }
}
