package q4classloader;

import org.apache.commons.io.FileUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;

//自定义类加载器
public class MyClassLoader extends ClassLoader{

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        String filename = name.substring(name.lastIndexOf(".") + 1);

        byte[] bytes = new byte[0];
        try {
            bytes = FileUtils.readFileToByteArray(new File("D:\\jvm\\data\\" + filename + ".class"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取字节码信息的二进制数据，调用defineClass方法
        return defineClass(name, bytes, 0, bytes.length);
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        MyClassLoader myClassLoader = new MyClassLoader();

        Class<?> clazz = myClassLoader.loadClass("com.itheima.springbootclassfile.pojo.vo.UserVO");

        //打印字段
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }

    }
}
