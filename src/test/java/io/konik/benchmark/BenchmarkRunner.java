/* Copyright (C) 2014 konik.io
 *
 * This file is part of the Konik library.
 *
 * The Konik library is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * The Konik library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with the Konik library. If not, see <http://www.gnu.org/licenses/>.
 */
package io.konik.benchmark;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openjdk.jmh.output.results.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * 
 * The Benchmark Runner.
 */
@SuppressWarnings("javadoc")
public class BenchmarkRunner {
   
   public static void main(String... args) throws RunnerException {
      SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd@HH-mm-ss");
      Options opt = new OptionsBuilder()
         .include(".*"  +"Benchmark" + ".*")
         .detectJvmArgs()
         .forks(1)
         .resultFormat(ResultFormatType.CSV)
         .result("benchmarks/all_"+d.format(new Date()) + ".txt")
   //      .addProfiler(ProfilerType.STACK)
         .build();
         new Runner(opt).run();
   }
}
