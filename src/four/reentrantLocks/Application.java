package four.reentrantLocks;

/*
 * ReentrantLock como alternativa a synchronized code block.
 * Ree-ntrantLocks permitem que você faça tudo o que pode fazer com synchronized, wait and notify,
 * além de mais algumas coisas que podem ser úteis de tempo ao tempo.
 */

public class Application {

	public static void main(String[] args) throws Exception {

		final Runner runner = new Runner();

		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					runner.firstThread();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
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