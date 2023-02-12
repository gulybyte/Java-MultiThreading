package one.implementsRunnable;

/*
 * via classe que implementa Runnable
 *  implementar a interface Runnable é a melhor prática para Multithreading * em Java
 */

 class Runner implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("Hello: " + i);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
<<<<<<< HEAD
=======
				// TODO Auto-generated catch block
>>>>>>> aed7c59 (one, two and three)
				e.printStackTrace();
			}
		}

	}

}

public class Application {

	public static void main(String[] args) {
		Thread thread1 = new Thread(new Runner());
		thread1.start();

		Thread thread2 = new Thread(new Runner());
		thread2.start();

		Thread thread3 = new Thread(new Runner());
		thread3.start();
	}

}