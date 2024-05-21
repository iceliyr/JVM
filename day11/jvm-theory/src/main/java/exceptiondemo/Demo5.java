package exceptiondemo;

public class Demo5 implements AutoCloseable {

    @Override
    public void close() {
        throw new RuntimeException("test2");
    }

    public static void main(String[] args) {
        // try-with-resources
        try (Demo5 d1 = new Demo5();
             Demo5 d2 = new Demo5()) {
            throw new RuntimeException("test2");
        }
    }
}
