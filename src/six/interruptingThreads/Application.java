package six.interruptingThreads;

/*
 * Interrompa threads em tempo de execução usando o built-in thread
 * mecanismo de interrupção.
 */

import java.util.Random;

public class Application {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("Starting. ");

		Thread t1 = new Thread(new Runnable() {
			public void run() {
				Random ran = new Random();

				for (int i = 0; i < 1E8; i++) {
					if(Thread.currentThread().isInterrupted())
					{
						System.out.println("Interrupted!");
						break;
					}
					Math.sin(ran.nextDouble());
				}

			}
		});
		t1.start();
		Thread.sleep(500);
		t1.interrupt();

		t1.join();
		System.out.println("Finished");
	}
}