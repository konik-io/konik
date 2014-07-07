/*
 * Copyright (C) 2014 konik.io
 *
 * This file is part of Konik library.
 *
 * Konik library is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Konik library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with Konik library.  If not, see <http://www.gnu.org/licenses/>.
 */
package io.konik.benchmark;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openjdk.jmh.results.format.ResultFormatType;
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