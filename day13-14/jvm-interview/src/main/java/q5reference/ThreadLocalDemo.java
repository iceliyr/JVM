package q5reference;

import java.io.IOException;

public class ThreadLocalDemo {

    public static ThreadLocal<User> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws IOException {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set(new User(2,"thread1线程对象"));

                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("线程1：" + threadLocal.get());
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set(new User(3,"thread2线程对象"));

                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("线程2：" + threadLocal.get());
            }
        });

        //启动线程
        thread1.start();
        thread2.start();

        //main方法线程中放入user对象
        threadLocal.set(new User(1,"main线程对象"));

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main线程：" + threadLocal.get());

        threadLocal.remove();

//        System.in.read();
    }
}

class User{
    int id;
    String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
