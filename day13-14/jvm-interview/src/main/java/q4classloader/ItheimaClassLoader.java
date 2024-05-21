package q4classloader;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

public class ItheimaClassLoader extends ClassLoader{

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if(name.startsWith("java.")){
            return super.loadClass(name);
        }
        //com.itheima.springbootclassfile.pojo.vo.UserVO .class
        String filename = name.substring(name.lastIndexOf(".") + 1) + ".class";
        //加载 D:/jvm/data
        byte[] bytes = new byte[0];
        try {
            bytes = FileUtils.readFileToByteArray(new File("D:\\教学\\同步课程资料\\BaiduSyncdisk\\实战Java虚拟机\\实战Java虚拟机\\代码\\day12\\jvm-interview\\target\\classes\\q4classloader\\" + filename));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return defineClass(name,bytes,0,bytes.length);
    }

    public static void main(String[] args) throws ClassNotFoundException {
        ItheimaClassLoader itheimaClassLoader = new ItheimaClassLoader();

        Class<?> clazz = itheimaClassLoader.loadClass("q4classloader.PrintParentClassLoader");

        //打印类字段
//        Field[] declaredFields = clazz.getDeclaredFields();
//        for (Field declaredField : declaredFields) {
//            System.out.println(declaredField.getName());
//        }

        //打印类加载器名字
        System.out.println(clazz.getClassLoader());

    }
}
