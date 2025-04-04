package org.acn;

import org.acn.threading.DownloadTask;
import org.acn.threading.MyRunnable;
import org.acn.threading.MyThread;
import org.acn.threading.TaskDownload;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        //MyThread t1 = new MyThread();
        //t1.start();

        //Thread t2 = new Thread( new MyRunnable());
        //t2.start();

        //ExecutorService executor = Executors.newFixedThreadPool(3);
        //executor.execute(new DownloadTask("archivo1.pdf"));
        //executor.execute(new DownloadTask("archivo2.pdf"));
        //executor.execute(new DownloadTask("archivo3.pdf"));
        //executor.shutdown();

        ExecutorService executor = Executors.newFixedThreadPool(3);
        String[] files = { "archivo1.pdf","archivo2.mp4","archivo3.docx","archivo4.jpg","arhcivo5.zip"};
        for(String file : files) {
            executor.execute( new TaskDownload(file) );
        }

        executor.shutdown();




    }

}