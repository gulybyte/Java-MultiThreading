package three.threadPools;

/*
 * gerenciando vários encadeamentos em Java usando pools de encadeamentos.
 *  Com pools de threads, você pode atribuir toda uma coleção de threads para trabalhar
 *  em sua fila de tarefas, fixando o número estaticamente para as filas.
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements Runnable {

	private int id;

	public Processor(int id) {
		this.id = id;
	}

	public void run() {
		System.out.println("Starting: " + id);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
            e.printStackTrace();
		}

		System.out.println("Completed: " + id);
	}
}

public class Application {

	public static void main(String[] args) {

		ExecutorService executor = Executors.newFixedThreadPool(2);

		for (int i = 0; i < 5; i++) {
			executor.submit(new Processor(i));
		}

		executor.shutdown();

		System.out.println("All tasks submitted.");

		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
		}

		System.out.println("All tasks completed.");
	}
}