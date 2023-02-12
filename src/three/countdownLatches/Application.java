package three.countdownLatches;

/*
 * Usando classe CountDownLatch para sincronizar as atividades de seus threads.
 */

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {

    public static void main(String[] args) {

        CountDownLatch latch = new CountDownLatch(3);

        ExecutorService executor = Executors.newFixedThreadPool(3);

        for(int i=0; i < 3; i++) {
            executor.submit(new Processor(latch));
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Completed.");
    }

}