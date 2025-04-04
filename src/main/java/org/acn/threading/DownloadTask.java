package org.acn.threading;

public class DownloadTask implements Runnable {

    private String fileName;

    public DownloadTask(String fileName) {
        this.fileName = fileName;
    }

    public void run() {

        System.out.println("Descargando " + fileName + " en " + Thread.currentThread().getName());
    }
}
