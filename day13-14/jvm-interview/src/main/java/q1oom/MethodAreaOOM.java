package q1oom;

import net.bytebuddy.jar.asm.ClassWriter;
import net.bytebuddy.jar.asm.Opcodes;

import java.io.IOException;

/**
 * JDK8 -XX:MaxMetaspaceSize=20m JDK7 -XX:MaxPermSize=20m
 */
public class MethodAreaOOM extends ClassLoader {
    public static void main(String[] args) throws IOException {
        MethodAreaOOM demo1 = new MethodAreaOOM();
        int count = 0;
        while (true) {
            String name = "Class" + count;
            ClassWriter classWriter = new ClassWriter(0);
            classWriter.visit(Opcodes.V1_7, Opcodes.ACC_PUBLIC, name, null
                    , "java/lang/Object", null);
            byte[] bytes = classWriter.toByteArray();
            demo1.defineClass(name, bytes, 0, bytes.length);
            System.out.println(++count);
        }
    }
}
