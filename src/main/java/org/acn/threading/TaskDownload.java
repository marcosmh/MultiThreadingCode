package org.acn.threading;

public class TaskDownload implements Runnable {

    private String fileName;

    public TaskDownload(String fileName) {
        this.fileName = fileName;
    }


    @Override
    public void run() {
        System.out.println("Descargando "+ fileName + " en " + Thread.currentThread().getName());

        try {
            Thread.sleep( (long) (Math.random() * 3000 ));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Descarga completada: " + fileName + " en " + Thread.currentThread().getName());
    }


}
