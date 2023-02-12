package five.callableAndFuture;

/*
 * Use Callable e Future em Java para obter resultados de seus threads
 * e para permitir que seus threads lancem exceptions. Além disso, o Future permite
 * você controlar seus threads, verificando se eles estão em execução ou
 * não, aguardando resultados e até interrompendo-os ou descheduling.
 */

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Application {

	public static void main(String[] args) {

		ExecutorService executor = Executors.newCachedThreadPool();

		Future<Integer> future = executor.submit(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				Random random = new Random();
				int duration = random.nextInt(4000);

				if (duration > 2000) {
					throw new IOException("Sleeping for too long.");
				}

				System.out.println("Starting ...");

				try {
					Thread.sleep(duration);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				System.out.println("Finished.");

				return duration;
			}

		});

		executor.shutdown();

		try {
			System.out.println("Result is: " + future.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			IOException ex = (IOException) e.getCause();

			System.out.println(ex.getMessage());
		}
	}

}