package org.acn.threading;

public class MyThread  extends Thread {

        public  void run () {
            System.out.println(" Hilo en ejecución: "+ Thread.currentThread().getName());
        }
}
