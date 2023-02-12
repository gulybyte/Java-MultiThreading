package five.semaphores;

/*
 * cria 200 threads e os dispara simultaneamente. todos eles tentam
 * executar o método connect() da classe Connection ao mesmo tempo.
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Application {

	public static void main(String[] args) throws Exception {

		ExecutorService executor = Executors.newCachedThreadPool();

		for (int i = 0; i < 200; i++) {
			executor.submit(new Runnable() {
				public void run() {
					Connection.getInstance().connect();
				}
			});
		}

		executor.shutdown();

		executor.awaitTermination(1, TimeUnit.DAYS);
	}

}