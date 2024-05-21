/*
 * Copyright (c) 2005, 2014, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

package org.sample;

import com.sun.management.OperatingSystemMXBean;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

//执行5轮预热，每次持续2秒
@Warmup(iterations = 5, time = 2, timeUnit = TimeUnit.SECONDS)
//输出毫秒单位
@OutputTimeUnit(TimeUnit.MILLISECONDS)
//统计方法执行的平均耗时
@BenchmarkMode(Mode.AverageTime)
//java -jar benchmarks.jar -rf json
@State(Scope.Benchmark)
public class MyBenchmark {

    //每次测试对象大小 4KB和4MB
    @Param({"4","4096"})
    int perSize;

    private void test(Blackhole blackhole){

        //每次循环创建堆内存60%对象 JMX获取到Java运行中的实时数据
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        //获取堆内存大小
        MemoryUsage heapMemoryUsage = memoryMXBean.getHeapMemoryUsage();
        //获取到剩余的堆内存大小
        long heapSize = (long) ((heapMemoryUsage.getMax() - heapMemoryUsage.getUsed()) * 0.6);
        //计算循环次数
        long size = heapSize / (1024 * perSize);

        for (int i = 0; i < 4; i++) {
            List<byte[]> objects = new ArrayList<>((int)size);
            for (int j = 0; j < size; j++) {
                objects.add(new byte[1024 * perSize]);
            }
            blackhole.consume(objects);
        }
    }

//    @Benchmark
//    @Fork(value = 1,jvmArgsAppend = {"-Xms4g","-Xmx4g","-XX:+UseSerialGC"})
//    public void serialGC(Blackhole blackhole){
//        test(blackhole);
//    }
//
//    @Benchmark
//    @Fork(value = 1,jvmArgsAppend = {"-Xms4g","-Xmx4g","-XX:+UseParallelGC"})
//    public void parallelGC(Blackhole blackhole){
//        test(blackhole);
//    }
//
//    @Benchmark
//    @Fork(value = 1,jvmArgsAppend = {"-Xms4g","-Xmx4g"})
//    public void g1(Blackhole blackhole){
//        test(blackhole);
//    }
//
//    @Benchmark
//    @Fork(value = 1,jvmArgsAppend = {"-Xms4g","-Xmx4g","-XX:+UseShenandoahGC"})
//    public void shenandoahGC(Blackhole blackhole){
//        test(blackhole);
//    }

    //-XX:+UseZGC -XX:+ZGenerational

    @Benchmark
    @Fork(value = 1,jvmArgsAppend = {"-Xms4g","-Xmx4g","-XX:+UseZGC","-XX:+UseLargePages"})
    public void zGC(Blackhole blackhole){
        test(blackhole);
    }

    @Benchmark
    @Fork(value = 1,jvmArgsAppend = {"-Xms4g","-Xmx4g","-XX:+UseZGC","-XX:+ZGenerational","-XX:+UseLargePages"})
    public void zGCGenerational(Blackhole blackhole){
        test(blackhole);
    }


    public static void main(String[] args) throws RunnerException {

        Options opt = new OptionsBuilder()
                .include(MyBenchmark.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
