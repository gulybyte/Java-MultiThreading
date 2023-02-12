package two.MultipleLocksUseSynch;

/*
 * multiplos lcks em complexas multi-thread's
 */

public class Application {

	public static void main(String[] args) {

		Worker worker = new Worker();
		worker.main();
	}

}