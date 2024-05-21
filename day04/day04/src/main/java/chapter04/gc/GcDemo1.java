package chapter04.gc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 垃圾回收器案例2
 */
//-XX:+UseSerialGC -Xmn10m -Xmx30m -XX:SurvivorRatio=8  -XX:+PrintGCDetails -verbose:gc
public class GcDemo1 {

    public static void main(String[] args) throws IOException {
        List<Object> list = new ArrayList<>();
        int count = 0;
        while (true){
            System.in.read();
            System.out.println(++count);
            //每次添加1m的数据
            list.add(new byte[1024 * 1024 * 1]);
        }
    }
}
