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

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class MyBenchmark {

    /**
     *  //1.入门案例
     */
    @Benchmark
    //输出纳秒单位
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    //统计方法执行的平均耗时
    @BenchmarkMode(Mode.AverageTime)
    public void testMethod(Blackhole blackhole) {
        int a = 1;
        a = a * 2;
        //使用黑洞，避免a变量没有使用被JIT当成死代码优化时去掉
        blackhole.consume(a);
    }

//    @State(Scope.Benchmark)
//    public static class BenchmarkState {
//        ArrayList<Integer> objects = new ArrayList<>();
//    }
//
//    @Benchmark
//    public void testMethod(BenchmarkState state) {
//        // place your benchmarked code here
//
//        state.objects.add(1);
//    }

//    public static void main(String[] args) throws RunnerException {
//        Options opt = new OptionsBuilder()
//                .include(MyBenchmark.class.getSimpleName())
//                .forks(1)
//                .build();
//
//        new Runner(opt).run();
//    }
}
