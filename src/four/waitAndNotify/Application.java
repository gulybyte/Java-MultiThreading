package four.waitAndNotify;

/*
 * Aguarde e notifique em Java; métodos de multithreading de baixo nível do
 * objeto classe que permite que você tenha um ou mais threads dormindo,
 * apenas para ser acordado por outros tópicos no momento certo.
 * Extremamente útil para evitar os loops de pesquisa que consomem o processador.
 */
public class Application {

    public static void main(String[] args) throws InterruptedException {

        final Processor processor = new Processor();

        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    processor.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    processor.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        
        t1.start();
        t2.start();
        
        t1.join();
        t2.join();
    }
}