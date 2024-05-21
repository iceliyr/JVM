package invokemethod;

import java.io.IOException;

public class MethodDemo {

    public static void main(String[] args) throws IOException {
        System.in.read();
        study();
    }

    public static void study() {
        eat();

        sleep();
    }

    public static void eat() {
        System.out.println("吃饭");
    }

    public static void sleep() {
        System.out.println("睡觉");
    }

}
