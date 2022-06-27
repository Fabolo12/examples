package lesson30;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static int count = 0;
    private static AtomicInteger integer = new AtomicInteger(0);

    @SneakyThrows
    public static void main(String[] args) {
       final Runnable runnable = () -> {
           for (int i = 0; i < 10000; i++) {
               count++;
               integer.incrementAndGet();
           }
       };

        for (int i = 0; i < 3; i++) {
          new Thread(runnable).start();
        }

        TimeUnit.SECONDS.sleep(1);
        System.out.println(count);
        System.out.println(integer.get());
    }


}

