package org.acn.threading;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class DataProcessor  implements Runnable {

    private List<String> batch;
    private CountDownLatch latch;


    public DataProcessor(List<String> batch, CountDownLatch latch) {
        this.batch = batch;
        this.latch = latch;
    }

    @Override
    public void run() {

        for(String record : batch ) {
            System.out.println("Procesando " + record + " en " + Thread.currentThread().getName());
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        latch.countDown();

    }
}
