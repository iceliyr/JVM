package demo2;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class MyClassVisitor extends ClassVisitor {
    private String methodName;
    private String className;
 
    public MyClassVisitor(ClassVisitor cv, String className, String methodName) {
        super(Opcodes.ASM9, cv);
        this.className = className;
        this.methodName = methodName;
    }
 
    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
        if (name.equals(methodName)) {
            return new MyMethodVisitor(mv);
        }
        return mv;
    }
 
    private class MyMethodVisitor extends MethodVisitor {
        public MyMethodVisitor(MethodVisitor mv) {
            super(Opcodes.ASM9, mv);
            visitMaxs(10,10);
        }

        @Override
        public void visitLineNumber(int line, Label start) {
            if (line == 4) {
                mv.visitLineNumber(line, start);
                mv.visitLabel(start);
                mv.visitIntInsn(Opcodes.SIPUSH,32768);
                mv.visitVarInsn(Opcodes.ISTORE,1);
            } else {
                super.visitLineNumber(line, start);
            }
        }

    }
}