package practice.threads;

/**
 * Implements thread using Runnable interface
 *
 * @author Yashraj R. Sontakke
 */
public class RunnableThreadExample implements Runnable {
    int count = 0;

    @Override
    public void run() {
        System.out.println("Thread Started");
        try {
            while (count < 5) {
                System.out.println("Count = " + count);
                Thread.sleep(500);
                count++;
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }
        System.out.println("Thread terminated");
    }

    public static void main(String[] args) {
        RunnableThreadExample runnableThreadExample = new RunnableThreadExample();
        Thread thread = new Thread(runnableThreadExample);
        thread.start();

        while (runnableThreadExample.count != 5) {
            try {
                System.out.println("Count less than 5");
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
