package four.lowLevelProducerConsumer;

/*
 * Implementação "low-level" do pattern producer-consumer, cnamely, wait, notify and synchronized.
 * Esta não é a melhor maneira de implementar um pattern producer-consumer em Java, mas ajuda a
 * entender como usar wait e notify
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