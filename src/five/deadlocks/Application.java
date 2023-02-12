package five.deadlocks;

/*
 * As causas do deadlock a duas coisas que pode-se fazer a respeito, prevenção e detecção.
 *  e também como escrever um método que pode adquirir com segurança qualquer número de locks em
 * qualquer ordem sem causar deadlock, usando o método tryLock() de ReentrantLock.
 */

public class Application {

    public static void main(String[] args) throws Exception {

        final Runner runner = new Runner();

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                try {
                    runner.firstThread();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                try {
                    runner.secondThread();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        runner.finished();
    }

}