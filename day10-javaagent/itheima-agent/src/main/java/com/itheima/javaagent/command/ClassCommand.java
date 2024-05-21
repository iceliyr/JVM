package com.itheima.javaagent.command;

import com.itheima.javaagent.enhancer.AsmEnhancer;
import com.itheima.javaagent.enhancer.MyAdvice;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.JavaModule;
import org.jd.core.v1.ClassFileToJavaSourceDecompiler;
import org.jd.core.v1.api.loader.Loader;
import org.jd.core.v1.api.loader.LoaderException;
import org.jd.core.v1.api.printer.Printer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;
import java.security.ProtectionDomain;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class ClassCommand {

    //打印所有类加载器
    public static void printAllClassLoader(Instrumentation inst){
        Set<ClassLoader> classLoaders = new HashSet<>();
        //获取所有类
        Class[] allLoadedClasses = inst.getAllLoadedClasses();

        for (Class allLoadedClass : allLoadedClasses) {
            ClassLoader classLoader = allLoadedClass.getClassLoader();
            classLoaders.add(classLoader);
        }

        //打印类加载器
        String str = classLoaders.stream().map(x -> {
            if (x == null) {
                return "BootStrapClassLoader";
            } else {
                return x.getName();
            }
        }).filter(x -> x != null).distinct().sorted(String::compareTo).collect(Collectors.joining(","));

        System.out.println(str);
    }
    
    //打印类的源代码
    public static void printClassSourceCode(Instrumentation inst){
        System.out.println("请输入类名:");
        //让用户输入类名
        Scanner scanner = new Scanner(System.in);
        String className = scanner.next();

        //根据类名找到class对象
        Class[] allLoadedClasses = inst.getAllLoadedClasses();
        for (Class allLoadedClass : allLoadedClasses) {
            if(allLoadedClass.getName().equals(className)){
                //找到了
                ClassFileTransformer transformer = new ClassFileTransformer() {
                    @Override
                    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {

                        //通过jd-core反编译并打印源代码
                        try {
                            printJDCoreSourceCode(classfileBuffer,className);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        return ClassFileTransformer.super.transform(loader, className, classBeingRedefined, protectionDomain, classfileBuffer);
                    }
                };

                //1.添加转换器
                inst.addTransformer(transformer,true);

                //2.手动触发转换
                try {
                    inst.retransformClasses(allLoadedClass);
                } catch (UnmodifiableClassException e) {
                    e.printStackTrace();
                }finally {
                    //3.删除转换器
                    inst.removeTransformer(transformer);
                }


            }
        }

    }

    //通过jd-core打印源代码
    private static void printJDCoreSourceCode(byte[] bytes,String className) throws Exception {
        //loader对象
        Loader loader = new Loader() {
            @Override
            public byte[] load(String internalName) throws LoaderException {
                return bytes;
            }

            @Override
            public boolean canLoad(String internalName) {
                return true;
            }
        };

        //printer对象
        Printer printer = new Printer() {
            protected static final String TAB = "  ";
            protected static final String NEWLINE = "\n";

            protected int indentationCount = 0;
            protected StringBuilder sb = new StringBuilder();

            @Override public String toString() { return sb.toString(); }

            @Override public void start(int maxLineNumber, int majorVersion, int minorVersion) {}
            @Override public void end() {
                //打印源代码
                System.out.println(sb);
            }

            @Override public void printText(String text) { sb.append(text); }
            @Override public void printNumericConstant(String constant) { sb.append(constant); }
            @Override public void printStringConstant(String constant, String ownerInternalName) { sb.append(constant); }
            @Override public void printKeyword(String keyword) { sb.append(keyword); }
            @Override public void printDeclaration(int type, String internalTypeName, String name, String descriptor) { sb.append(name); }
            @Override public void printReference(int type, String internalTypeName, String name, String descriptor, String ownerInternalName) { sb.append(name); }

            @Override public void indent() { this.indentationCount++; }
            @Override public void unindent() { this.indentationCount--; }

            @Override public void startLine(int lineNumber) { for (int i=0; i<indentationCount; i++) sb.append(TAB); }
            @Override public void endLine() { sb.append(NEWLINE); }
            @Override public void extraLine(int count) { while (count-- > 0) sb.append(NEWLINE); }

            @Override public void startMarker(int type) {}
            @Override public void endMarker(int type) {}
        };

        //通过jd-core方法打印
        ClassFileToJavaSourceDecompiler decompiler = new ClassFileToJavaSourceDecompiler();

        decompiler.decompile(loader, printer, className);

    }

    //对类进行增强，统计执行耗时
    public static void enhanceClass(Instrumentation inst){
        System.out.println("请输入类名:");
        //让用户输入类名
        Scanner scanner = new Scanner(System.in);
        String className = scanner.next();

        //根据类名找到class对象
        Class[] allLoadedClasses = inst.getAllLoadedClasses();
        for (Class allLoadedClass : allLoadedClasses) {
            if(allLoadedClass.getName().equals(className)){

                //使用bytebuddy增强类
                new AgentBuilder.Default()
                        //禁止byte buddy处理时修改类名
                        .disableClassFormatChanges()
                        //处理时使用retransform增强
                        .with(AgentBuilder.RedefinitionStrategy.RETRANSFORMATION)
                        //打印出错误日志
                        .with(new AgentBuilder.Listener.WithTransformationsOnly(AgentBuilder.Listener.StreamWriting
                                .toSystemOut()))
                        //匹配哪些类
                        .type(ElementMatchers.named(className))
                        //增强，使用MyAdvice通知，对所有方法都进行增强
                        .transform((builder, typeDescription, classLoader, module, protectionDomain) ->
                                builder.visit(Advice.to(MyAdvice.class).on(ElementMatchers.any())))
                        .installOn(inst);

//                //找到了
//                ClassFileTransformer transformer = new ClassFileTransformer() {
//                    @Override
//                    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
//                        //通过ASM对类进行增强，返回字节码信息
//                        byte[] bytes = AsmEnhancer.enhanceClass(classfileBuffer);
//                        return bytes;
//                    }
//                };
//
//                //1.添加转换器
//                inst.addTransformer(transformer,true);
//
//                //2.手动触发转换
//                try {
//                    inst.retransformClasses(allLoadedClass);
//                } catch (UnmodifiableClassException e) {
//                    e.printStackTrace();
//                }finally {
//                    //3.删除转换器
//                    inst.removeTransformer(transformer);
//                }


            }
        }
    }
}
