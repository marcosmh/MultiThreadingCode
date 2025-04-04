package org.acn.threading;

public class MyRunnable implements Runnable {

    public void run() {
        System.out.println("Hilo ejecucion: "+ Thread.currentThread().getName());
    }
}
