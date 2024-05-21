package org.sample;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.sample.demo.JMHSample_08_DeadCode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

//执行5轮预热，每次持续1秒
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
//执行一次测试
@Fork(value = 1, jvmArgsAppend = {"-Xms1g", "-Xmx1g"})
//显示平均时间，单位纳秒
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
public class ToArrayBench {

    //分别放入不同大小数据进行测试
    @Param({"0", "1", "10", "100", "1000"})
    int size;

    //两种集合
    @Param({"arraylist","linkedlist"})
    String type;

    Collection<Foo> coll;

    @Setup
    public void setup() {
        if (type.equals("arraylist")) {
            coll = new ArrayList<>();
        } else if (type.equals("linkedlist")) {
            coll = new LinkedList<>();
        } else {
            throw new IllegalStateException();
        }
        for (int i = 0; i < size; i++) {
            coll.add(new Foo(i));
        }
    }

    @Benchmark
    public Object[] simple() {
        return coll.toArray();
    }

    @Benchmark
    public Foo[] zero() {
        return coll.toArray(new Foo[0]);
    }

    @Benchmark
    public Foo[] sized() {
        return coll.toArray(new Foo[coll.size()]);
    }

    public static class Foo {
        private int i;

        public Foo(int i) {
            this.i = i;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Foo foo = (Foo) o;
            return i == foo.i;
        }

        @Override
        public int hashCode() {
            return i;
        }
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(ToArrayBench.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}