package io.konik.csv.pdf;

import java.util.Comparator;

import javax.annotation.Nullable;

import com.google.common.base.Function;

import io.konik.harness.FileAppender;

/**
 * {@link FileAppender} {@link Comparator} that uses {@code FileAppender.getPriority()} method
 * to define correct order.
 *
 * Objects with higher priority come first.
 */
public class FileAppenderPriorityComparator implements Comparator<FileAppender> {

   public enum Order {
      DESC(new Function<Integer, Integer>() {
         public Integer apply(Integer input) {
            return input * -1;
         }
      }),
      ASC(new Function<Integer, Integer>() {
         public Integer apply(@Nullable Integer input) {
            return input;
         }
      });

      private Function<Integer, Integer> transform;

      Order(Function<Integer, Integer> transform) {
         this.transform = transform;
      }

      public Integer apply(Integer value) {
         return this.transform.apply(value);
      }
   }

   private final Order order;

   public FileAppenderPriorityComparator(Order order) {
      this.order = order;
   }

   @Override
   public int compare(FileAppender fa1, FileAppender fa2) {
      if (fa1 != null && fa2 != null) {
         return order.apply(fa1.getPriority() - fa2.getPriority());
      }

      if (fa1 != null) {
         return order.apply(1);
      }

      return 0;
   }
}
