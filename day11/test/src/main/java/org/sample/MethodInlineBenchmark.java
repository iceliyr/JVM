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
//
////执行5轮预热，每次持续1秒
//@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
////执行一次测试
//@Fork(value = 1, jvmArgsAppend = {"-Xms1g", "-Xmx1g"})
////显示平均时间，单位纳秒
//@BenchmarkMode(Mode.AverageTime)
//@OutputTimeUnit(TimeUnit.NANOSECONDS)
//@State(Scope.Benchmark)
//public class MethodInlineBenchmark {
//
//    public static final String SOURCE = "AbCdEfG";
//
//    public String toUpperCaseASCII(String source){
//        int length = source.length();
//        char[] chars = new char[length];
//
//        for (int i = 0; i < length; i++) {
//            char c = source.charAt(i);
//            if(c >= 'a' && c <= 'z'){
//                c -= 32;
//            }
//            chars[i] = c;
//        }
//        return new String(chars);
//    }
//    //分层编译
//    @Benchmark
//    public void testMethodJDK(Blackhole blackhole) {
//        String s = SOURCE.toUpperCase();
//        blackhole.consume(s);
//    }
//
//    @Benchmark
//    public void testMethodASC(Blackhole blackhole) {
//        String s = toUpperCaseASCII(SOURCE);
//        blackhole.consume(s);
//    }
//
//
//
//    public static void main(String[] args) throws RunnerException {
//        Options opt = new OptionsBuilder()
//                .include(MethodInlineBenchmark.class.getSimpleName())
//                .forks(1)
//                .build();
//
//        new Runner(opt).run();
//    }
//}
