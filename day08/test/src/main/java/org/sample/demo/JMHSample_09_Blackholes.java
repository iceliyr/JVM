package org.sample.demo;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
public class JMHSample_09_Blackholes {

    /*
     * Should your benchmark require returning multiple results, you have to
     * consider two options (detailed below).
     *
     * NOTE: If you are only producing a single result, it is more readable to
     * use the implicit return, as in JMHSample_08_DeadCode. Do not make your benchmark
     * code less readable with explicit Blackholes!
     */

    double x1 = Math.PI;
    double x2 = Math.PI * 2;

    private double compute(double d) {
        for (int c = 0; c < 10; c++) {
            d = d * d / Math.PI;
        }
        return d;
    }

//
//    @Benchmark
//    public double measureWrong() {
//        compute(x1);
//        return compute(x2);
//    }

    @Benchmark
    public void measureRight_2(Blackhole bh) {
        bh.consume(compute(x1));
        bh.consume(compute(x2));
    }

    /*
     * ============================== HOW TO RUN THIS TEST: ====================================
     *
     * You will see measureWrong() running on-par with baseline().
     * Both measureRight() are measuring twice the baseline, so the logs are intact.
     *
     * You can run this test:
     *
     * a) Via the command line:
     *    $ mvn clean install
     *    $ java -jar target/benchmarks.jar JMHSample_09 -f 1
     *    (we requested single fork; there are also other options, see -h)
     *
     * b) Via the Java API:
     *    (see the JMH homepage for possible caveats when running from IDE:
     *      http://openjdk.java.net/projects/code-tools/jmh/)
     */

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(JMHSample_09_Blackholes.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }


}