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
//import java.util.Random;
//import java.util.concurrent.TimeUnit;
//
////执行5轮预热，每次持续1秒
//@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
////执行一次测试
////显示平均时间，单位纳秒
//@BenchmarkMode(Mode.AverageTime)
//@OutputTimeUnit(TimeUnit.MILLISECONDS)
//@Measurement(iterations = 3,time = 1,timeUnit = TimeUnit.SECONDS)
//@State(Scope.Benchmark)
//public class EscapeAnalysisBenchmark {
//
//    public int test(){
//        Random random = new Random();
//        int count = 0;
//        for (int i = 0; i < 10000000; i++) {
//            Demo2Test d1 = new Demo2Test(random.nextInt(10));
//            Demo2Test d2 = new Demo2Test(random.nextInt(10));
//            if(d1.equals(d2)){
//                count++;
//            }
//        }
//        return count;
//    }
//
//    @Benchmark
//    @Fork(value = 1,jvmArgsAppend = {"-Xmx10m"})
//    public void testWithJIT(Blackhole blackhole) {
//        int i = test();
//        blackhole.consume(i);
//    }
//
//    @Benchmark
//    @Fork(value = 1,jvmArgsAppend = {"-XX:-DoEscapeAnalysis","-Xmx10m"})
//    public void testWithoutEA(Blackhole blackhole) {
//        int i = test();
//        blackhole.consume(i);
//    }
//
//    @Benchmark
//    @Fork(value = 1,jvmArgsAppend = {"-Xint","-Xmx10m"})
//    public void testWithoutJIT(Blackhole blackhole) {
//        int i = test();
//        blackhole.consume(i);
//    }
//
//}
//
//
//class Demo2Test{
//    final int a;
//
//    public Demo2Test(int a) {
//        this.a = a;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        return this.a == ((Demo2Test)o).a;
//    }
//
//}