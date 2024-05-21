///*
// * Copyright (c) 2005, 2014, Oracle and/or its affiliates. All rights reserved.
// * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
// *
// * This code is free software; you can redistribute it and/or modify it
// * under the terms of the GNU General Public License version 2 only, as
// * published by the Free Software Foundation.  Oracle designates this
// * particular file as subject to the "Classpath" exception as provided
// * by Oracle in the LICENSE file that accompanied this code.
// *
// * This code is distributed in the hope that it will be useful, but WITHOUT
// * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
// * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
// * version 2 for more details (a copy is included in the LICENSE file that
// * accompanied this code).
// *
// * You should have received a copy of the GNU General Public License version
// * 2 along with this work; if not, write to the Free Software Foundation,
// * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
// *
// * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
// * or visit www.oracle.com if you need additional information or have any
// * questions.
// */
//
//package org.sample;
//
//import org.openjdk.jmh.annotations.*;
//import org.openjdk.jmh.infra.Blackhole;
//import org.openjdk.jmh.runner.Runner;
//import org.openjdk.jmh.runner.RunnerException;
//import org.openjdk.jmh.runner.options.Options;
//import org.openjdk.jmh.runner.options.OptionsBuilder;
//
//import java.util.concurrent.TimeUnit;
////执行5轮预热，每次持续1秒
//@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
////执行一次测试
//@Fork(value = 1, jvmArgsAppend = {"-Xms1g", "-Xmx1g"})
////显示平均时间，单位纳秒
//@BenchmarkMode(Mode.AverageTime)
//@OutputTimeUnit(TimeUnit.NANOSECONDS)
//@State(Scope.Benchmark)
//public class MyJITBenchmark {
//
//    public int add (int a,int b){
//        return a + b;
//    }
//
//    public int jitTest(){
//        int sum = 0;
//        for (int i = 0; i < 10000000; i++) {
//            sum = add(sum,100);
//        }
//        return sum;
//    }
//
//
//    //禁用JIT
//    @Benchmark
//    @Fork(value = 1,jvmArgsAppend = {"-Xint"})
//    public void testNoJIT(Blackhole blackhole) {
//        int i = jitTest();
//        blackhole.consume(i);
//    }
//
//    //只使用C1 1层
//    @Benchmark
//    @Fork(value = 1,jvmArgsAppend = {"-XX:TieredStopAtLevel=1"})
//    public void testC1(Blackhole blackhole) {
//        int i = jitTest();
//        blackhole.consume(i);
//    }
//
//    //分层编译
//    @Benchmark
//    public void testMethod(Blackhole blackhole) {
//        int i = jitTest();
//        blackhole.consume(i);
//    }
//
//    public static void main(String[] args) throws RunnerException {
//        Options opt = new OptionsBuilder()
//                .include(MyJITBenchmark.class.getSimpleName())
//                .forks(1)
//                .build();
//
//        new Runner(opt).run();
//    }
//}
