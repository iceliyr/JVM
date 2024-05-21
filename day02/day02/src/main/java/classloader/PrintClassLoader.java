package classloader;

public class PrintClassLoader {
    public static void main(String[] args) {
        System.out.println(System.getProperty("java.class.path"));
        A a = new A();
        System.out.println(A.class.getClassLoader());
        System.out.println(String.class.getClassLoader());

        ClassLoader classLoader = PrintClassLoader.class.getClassLoader();
        while(classLoader != null){
            System.out.println(classLoader);
            classLoader = classLoader.getParent();
        }
    }
}

class A{

}
