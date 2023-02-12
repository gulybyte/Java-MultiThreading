package five.semaphores;

/*
 * * Os Semaphores são usados principalmente para limitar o número de threads simultâneos que
  * pode acessar recursos, mas também pode usá-los para implementar deadlock
  * sistemas de recuperação, pois um Semaphore com uma permissão é basicamente um bloqueio que
  * você pode desbloquear de outras Threads.
 */

import java.util.concurrent.Semaphore;

public class Connection {

    private static Connection instance = new Connection();

    private Semaphore sem = new Semaphore(10, true);

    private int connections = 0;

    private Connection() {

    }

    public static Connection getInstance() {
        return instance;
    }

    public void connect() {
        try {
            sem.acquire();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        try {
            doConnect();
        } finally {

            sem.release();
        }
    }

    public void doConnect() {

        synchronized (this) {
            connections++;
            System.out.println("Current connections: " + connections);
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (this) {
            connections--;
        }

    }
}