package com.itheima.javaagent.command;

import com.sun.management.HotSpotDiagnosticMXBean;

import java.io.IOException;
import java.lang.management.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MemoryCommand {

    //打印所有内存信息
    public static void printMemory(){
        List<MemoryPoolMXBean> memoryPoolMXBeans = ManagementFactory.getMemoryPoolMXBeans();

        System.out.println("堆内存:");
        //堆内存
        getMemoryInfo(memoryPoolMXBeans, MemoryType.HEAP);

        System.out.println("非堆内存:");
        //非堆内存
        getMemoryInfo(memoryPoolMXBeans, MemoryType.NON_HEAP);

        System.out.println("nio相关内存：");
        //打印nio相关内存
        try {
            Class clazz = Class.forName("java.lang.management.BufferPoolMXBean");
            List<BufferPoolMXBean> bufferPoolMXBeans = ManagementFactory.getPlatformMXBeans(clazz);

            //打印内容
            for (BufferPoolMXBean bufferPoolMXBean : bufferPoolMXBeans) {
                StringBuilder sb = new StringBuilder();
                sb.append("name:")
                        .append(bufferPoolMXBean.getName())
                        .append(" used:")
                        .append(bufferPoolMXBean.getMemoryUsed() / 1024 / 1024)
                        .append("m")

                        .append(" capacity:")
                        .append(bufferPoolMXBean.getTotalCapacity() / 1024 / 1024)
                        .append("m");

                System.out.println(sb);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    private static void getMemoryInfo(List<MemoryPoolMXBean> memoryPoolMXBeans, MemoryType heap) {
        memoryPoolMXBeans.stream().filter(x -> x.getType().equals(heap))
                .forEach(x -> {
                    StringBuilder sb = new StringBuilder();
                    sb.append("name:")
                            .append(x.getName())
                            .append(" used:")
                            .append(x.getUsage().getUsed() / 1024 / 1024)
                            .append("m")

                            .append(" committed:")
                            .append(x.getUsage().getCommitted() / 1024 / 1024)
                            .append("m")

                            .append(" max:")
                            .append(x.getUsage().getMax() / 1024 / 1024)
                            .append("m");
                    System.out.println(sb);
                });
    }

    //生成内存快照
    public static void heapDump(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm");

        HotSpotDiagnosticMXBean hotSpotDiagnosticMXBean =
                ManagementFactory.getPlatformMXBean(HotSpotDiagnosticMXBean.class);

        try {
            hotSpotDiagnosticMXBean.dumpHeap(simpleDateFormat.format(new Date()) + ".hprof",true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
