package com.itheima.javaagent;

import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class AttachMain {
    public static void main(String[] args) throws IOException, AttachNotSupportedException, AgentLoadException, AgentInitializationException {
        //获取进程列表，让用户手动进行输入
        //1.执行jps命令，打印所有进程列表
        Process jps = Runtime.getRuntime().exec("jps");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(jps.getInputStream()));
        try{
            String line;
            while((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }
        }finally {
            if(bufferedReader != null){
                bufferedReader.close();
            }
        }
        //2.输入进程id
        Scanner scanner = new Scanner(System.in);
        String processId = scanner.next();

        //获取进程虚拟机对象
        VirtualMachine vm = VirtualMachine.attach(processId);
        //执行java agent里边的agentmain方法
        vm.loadAgent("itheima-jvm-java-agent-jar-with-dependencies.jar");
    }
}
