package demo2;

import org.apache.commons.io.IOUtils;

import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String className = "Demo02";
        String methodName = "main";
        byte[] modifiedBytes = MyClassReader.modifyClass(className, methodName);
        // 将修改后的字节码保存到文件或加载到内存中
        IOUtils.write(modifiedBytes,new FileOutputStream("D:\\Demo02.class"));
    }
}