//package com.itheima.jvmoptimize;
//
//import com.itheima.jvmoptimize.performance.practice.controller.UserController2;
//import org.junit.jupiter.api.Test;
//import org.openjdk.jmh.annotations.*;
//import org.openjdk.jmh.infra.Blackhole;
//import org.openjdk.jmh.results.format.ResultFormatType;
//import org.openjdk.jmh.runner.Runner;
//import org.openjdk.jmh.runner.RunnerException;
//import org.openjdk.jmh.runner.options.OptionsBuilder;
//import org.springframework.boot.SpringApplication;
//import org.springframework.context.ApplicationContext;
//
//import java.io.IOException;
//import java.util.concurrent.TimeUnit;
//
////执行5轮预热，每次持续1秒
//@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
////执行一次测试
//@Fork(value = 1, jvmArgsAppend = {"-Xms1g", "-Xmx1g"})
////显示平均时间，单位纳秒
//@BenchmarkMode(Mode.AverageTime)
//@OutputTimeUnit(TimeUnit.MILLISECONDS)
//@State(Scope.Benchmark)
//public class PracticeBenchmarkTest2 {
//
//
//    private UserController2 userController;
//    private ApplicationContext context;
//
//    @Setup
//    public void setup() {
//        this.context = new SpringApplication(JvmOptimizeApplication.class).run();
//        userController = this.context.getBean(UserController2.class); //UserService
//    }
//
//    @Test
//    public void executeJmhRunner() throws RunnerException, IOException {
//
//        new Runner(new OptionsBuilder()
//                .shouldDoGC(true)
//                .forks(0)
//                .resultFormat(ResultFormatType.JSON)
//                .shouldFailOnError(true)
//                .build()).run();
//    }
//
//    @Benchmark
//    public void test1(final Blackhole bh) {
//
//        bh.consume(userController.user1());
//    }
//    @Benchmark
//    public void test3(final Blackhole bh) {
//
//        bh.consume(userController.user3());
//    }
//    @Benchmark
//    public void test4(final Blackhole bh) {
//
//        bh.consume(userController.user4());
//    }
//    @Benchmark
//    public void test5(final Blackhole bh) {
//
//        bh.consume(userController.user5());
//    }
//    @Benchmark
//    public void test2(final Blackhole bh) {
//
//        bh.consume(userController.user2());
//    }
//}