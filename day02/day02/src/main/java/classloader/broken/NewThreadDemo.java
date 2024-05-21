package classloader.broken;

/**
 * 线程上下文类加载器测试
 */
public class NewThreadDemo {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getContextClassLoader());
            }
        }).start();
    }
}
