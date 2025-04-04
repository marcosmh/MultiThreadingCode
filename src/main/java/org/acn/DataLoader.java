package org.acn;

import org.acn.threading.DataProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DataLoader {

    private static final int TOTAL_RECORDS = 100000;
    private static final int BATCH_SIZE = 1000;
    private static final int THREAD_POOL_SIZE = 10;

    public static void main(String[] args) {
        System.out.println("Iniciando Carga masiva de datos. ");


        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        List<String> records = generateData(TOTAL_RECORDS);
        int batchCount = (int) Math.ceil((double) TOTAL_RECORDS / BATCH_SIZE);
        CountDownLatch latch = new CountDownLatch(batchCount);

        for (int i = 0; i < TOTAL_RECORDS; i+= BATCH_SIZE) {
            List<String> batch = records.subList(i, Math.min(i + BATCH_SIZE, TOTAL_RECORDS));
            executor.execute(new DataProcessor(batch,latch));
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        executor.shutdown();
        System.out.println("Carga masiva de datos completada. ");


    }

    private static List<String> generateData(int totalRecords) {
        List<String> data = new ArrayList<>();
        for( int i=1; i <= totalRecords; i++ ) {
            data.add("Registro-"+i);
        }
        return data;

    }
}
