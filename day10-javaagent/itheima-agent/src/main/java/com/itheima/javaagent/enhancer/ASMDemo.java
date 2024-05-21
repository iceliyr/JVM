package com.itheima.javaagent.enhancer;

import org.apache.commons.io.FileUtils;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

import java.io.File;
import java.io.IOException;

import static org.objectweb.asm.Opcodes.ASM7;
import static org.objectweb.asm.Opcodes.ICONST_0;

//ASM入门案例，向每个方法添加一行字节码指令
public class ASMDemo {
    public static void main(String[] args) throws IOException {
        //1.从本地读取一个字节码文件，byte[]
        byte[] bytes = FileUtils.readFileToByteArray(new File("D:\\jvm\\AttachMain.class"));

        //2.通过ASM修改字节码文件
        //将二进制数据转换成可以解析内容
        ClassReader classReader = new ClassReader(bytes);

        //创建visitor对象，修改字节码信息
        ClassWriter classWriter = new ClassWriter(0);
        ClassVisitor classVisitor = new ClassVisitor(ASM7,classWriter){
            @Override
            public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {

                MethodVisitor mv = super.visitMethod(access, name, descriptor, signature, exceptions);
                //返回自定义的MethodVisitor
                MethodVisitor methodVisitor = new MethodVisitor(this.api,mv){
                    //修改字节码指令

                    @Override
                    public void visitCode() {
                        //插入一行字节码指令 ICONST_0
                        visitInsn(ICONST_0);
                    }
                };

                return methodVisitor;
            }
        };

        classReader.accept(classVisitor,0);


        //3.将修改完的字节码信息写入文件中，进行替换
        FileUtils.writeByteArrayToFile(new File("D:\\jvm\\AttachMain.class"),classWriter.toByteArray());

    }
}
