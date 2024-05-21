package chapter04.gc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 垃圾回收器案例3
 */
//-XX:+UseSerialGC -Xmn1g -Xmx16g -XX:SurvivorRatio=8  -XX:+PrintGCDetails -verbose:gc -XX:+PrintFlagsFinal
//-XX:+UseParNewGC  -Xmn1g -Xmx16g -XX:SurvivorRatio=8  -XX:+PrintGCDetails -verbose:gc
//-XX:+UseConcMarkSweepGC
//-XX:+UseG1GC   -Xmn8g -Xmx16g -XX:SurvivorRatio=8  -XX:+PrintGCDetails -verbose:gc MaxGCPauseMillis
//-XX:+PrintFlagsFinal  -XX:GCTimeRatio = 19  -XX:MaxGCPauseMillis=10 -XX:+UseAdaptiveSizePolicy
public class GcDemo2 {

    public static void main(String[] args) throws IOException {
        int count = 0;
        List<Object> list = new ArrayList<>();
        while (true){
            //System.out.println(++count);
            if(count++ % 10240 == 0){
                list.clear();
            }
//            byte[] bytes = new byte[1024 * 1024 * 1];
            list.add(new byte[1024 * 1024 * 1 / 2]);
//            System.gc();
        }
    }
}
