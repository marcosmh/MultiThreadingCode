package org.acn.threading;

public class MusicPlayer implements Runnable {

    private String songName;
    private volatile boolean isPaused = false;
    private volatile boolean isStopped = false;


    public MusicPlayer(String songName) {
        this.songName = songName;
    }

    public void pause() {
        isPaused = true;
        System.out.println("Canción pausada...");
    }

    public void resume() {
        isPaused = false;
        synchronized (this) {
            notify();
        }

        System.out.println("Reproducción reanudada....");
    }

    public void stop() {
        isStopped = true;
        System.out.println("Canción detenida...");
    }

    @Override
    public void run() {
        System.out.println("Reproduciendo " +  songName);

        for( int i=0; i <= 10; i++ ) {
            if(isStopped) {
                break;
            }

            synchronized (this) {
                while (isPaused) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            System.out.println("Sonando .... segundo " + i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Cancion terminada");



        }

    }
}
