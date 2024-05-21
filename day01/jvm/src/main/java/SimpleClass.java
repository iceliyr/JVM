import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class SimpleClass implements Fly {
    private final static int a1 = 0;
    private int a2 = 0;

    public static void main(String[] args) {

        Class<SimpleClass> clazz = SimpleClass.class;
        //获取方法信息
        Method[] methods = clazz.getMethods();
        //获取字段信息
        Field[] fields = clazz.getFields();

        String str1 = "123";
        String str2 = "123";
        int a = 1;
        System.out.println("123");
    }

    @Override
    public void fly() {
        System.out.println("fly");
    }
}
