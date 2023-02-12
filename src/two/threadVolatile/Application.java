package two.threadVolatile;

/*
 * Encerrando um thread de outro thread com volatile
 *  Volatile significa que a variavel pode ser alterada por outra Thread
 *  No geral o código ficar em loop infinito até que o usuario pressione enter
 *   no console que então abrira uma Thread que fechara essa thread infinita
 */

import java.util.Scanner;

class Processor extends Thread {

     private volatile boolean running = true;

     public void run() {

         while (running) {
             System.out.println("Running");

             try {
                 Thread.sleep(50);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
     }

     public void shutdown() {
         running = false;
     }
 }

 public class Application {

     public static void main(String[] args) {
         Processor pro = new Processor();
         pro.start();

         // Wait for the enter key
         new Scanner(System.in).nextLine();

         pro.shutdown();
     }

 }
