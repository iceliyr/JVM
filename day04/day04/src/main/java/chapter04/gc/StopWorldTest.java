package chapter04.gc;

import lombok.SneakyThrows;

import java.util.LinkedList;
import java.util.List;

/**
 * STW测试
 */
public class StopWorldTest {
    public static void main(String[] args) {
        new PrintThread().start();
        new ObjectThread().start();
    }
}

class PrintThread extends Thread{

    @SneakyThrows
    @Override
    public void run() {
        //记录开始时间

        long last = System.currentTimeMillis();
        while(true){
            long now = System.currentTimeMillis();
            System.out.println(now - last);
            last = now;
            Thread.sleep(100);
        }
    }
}

class ObjectThread extends Thread{

    @SneakyThrows
    @Override
    public void run() {
        List<byte[]> bytes = new LinkedList<>();
        while(true){
            //最多存放8g，然后删除强引用，垃圾回收时释放8g
            if(bytes.size() >= 80){
                bytes.clear();
            }
            bytes.add(new byte[1024 * 1024 * 100]);
            Thread.sleep(10);
        }
    }
}