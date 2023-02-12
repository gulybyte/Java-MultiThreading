package one.anonymousThread;

/*
 * Função Thread sob construtor Anonimo
 *  dentro roda um for que roda um laço a cada 1 segundo
 */

public class Application {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override public void run() {
                for (int i = 0; i < 5; i++) {
					System.out.println("Hello: " + i);
					try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
				}
            }
        }).start();
    }
}
