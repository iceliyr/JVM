package classloader.arthas;//package com.itheima.jvm.chapter02.classloader.arthas;

import jdk.nashorn.internal.runtime.ScriptEnvironment;

import java.io.IOException;

/**
 * 扩展类加载器
 */
public class ExtClassLoaderDemo {
    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = ScriptEnvironment.class.getClassLoader();
        System.out.println(classLoader);
    }
}
