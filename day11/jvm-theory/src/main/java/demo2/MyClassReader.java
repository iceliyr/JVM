package demo2;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

import java.io.IOException;

public class MyClassReader {
    public static byte[] modifyClass(String className, String methodName) throws IOException {
        ClassReader cr = new ClassReader(className);
        ClassWriter cw = new ClassWriter(cr, ClassWriter.COMPUTE_MAXS);
        MyClassVisitor cv = new MyClassVisitor(cw, className, methodName);
        cr.accept(cv, 0);
        return cw.toByteArray();
    }
}