package org.acn;

import org.acn.threading.MusicPlayer;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SpotifyApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ExecutorService executor = Executors.newSingleThreadExecutor();
        MusicPlayer player = new MusicPlayer("Hypocrisy - Roswell47");
        executor.execute(player);

        while (true) {

            System.out.println("\nComandos: (1)Pausar | (2)Reanudar | (3) Detener | (4)Salir ");
            int command = scanner.nextInt();

            switch (command) {

                case 1:
                    player.pause();
                    break;
                case 2:
                    player.resume();
                    break;
                case 3:
                    player.stop();
                    break;
                case 4:
                    executor.shutdown();
                    System.out.println("Saliendo de la Aplicación");
                    return;
                default:
                    System.out.println("Comando no valido");

            }


        }


    }
}
