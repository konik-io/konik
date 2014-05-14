package io.konik.benchmark;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openjdk.jmh.output.results.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
@SuppressWarnings("javadoc")
public class DefaultBenchmark {
   
   public void runDefault() throws RunnerException {
      SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd@HH-mm-ss");
      String className = this.getClass().getSimpleName();
      Options opt = new OptionsBuilder()
         .include(".*" + className + ".*")
         .detectJvmArgs()
         .forks(1)
         .resultFormat(ResultFormatType.CSV)
         .result("benchmarks/"+ className + "_"+d.format(new Date()) + ".txt")
   //      .addProfiler(ProfilerType.STACK)
         .build();
         new Runner(opt).run();
   }
}