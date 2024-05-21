package q6gc;

//-verbose:gc -Xmx100m
//-XX:+UseSerialGC 新生代、老年代都使用串行回收器。
//-XX:+UseConcMarkSweepGC
public class GcDemo {
    public static void main(String[] args) {
        while (true){
            byte[] bytes = new byte[1024 * 1024 * 10];
        }
    }
}
