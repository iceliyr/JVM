package q5reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

//-Xmx10m -verbose:gc
public class PhantomReferenceDemo {
    private static int _1MB = 1024 * 1024 * 1;
    public static void main(String[] args) {
        ReferenceQueue<byte[]> queue = new ReferenceQueue();
        byte[] bytes = new byte[_1MB];
        MyPhantomReference phantomReference = new MyPhantomReference(bytes, queue);

        //去除强引用
        bytes = null;
        //执行垃圾回收
        System.gc();

        //查看队列
        MyPhantomReference ref = (MyPhantomReference) queue.poll();
        //清理
        ref.clean();

    }
}

class MyPhantomReference extends PhantomReference<byte[]>{
    public void clean(){
        System.out.println("清理...");
    }

    public MyPhantomReference(byte[] referent, ReferenceQueue<byte[]> q) {
        super(referent, q);
    }
}