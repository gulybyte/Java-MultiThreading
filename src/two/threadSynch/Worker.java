package two.threadSynch;

/*
 * usando synchronized
 *  Isso significa que apenas uma thread pode acessar este método ao mesmo tempo, garantindo
 *  que a atualização da variável count seja atomicamente segura
 */


public class Worker {

    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public static void main(String[] args) {
    	Worker worker = new Worker();
    	worker.run();
    }

    public void run() {
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                for(int i = 0; i < 10000; i++) {
                    increment();
                }
            }
        });
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                for(int i = 0; i < 10000; i++) {
                    increment();
                }
            }
        });
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Count is: " + count);

    }
}
