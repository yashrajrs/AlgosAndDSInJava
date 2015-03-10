package practice.threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Thread locks monitor example
 *
 * @author Yashraj R. Sontakke
 */
public class LockedAtm {
    private Lock lock;
    private int balance = 100;

    public LockedAtm() {
        lock = new ReentrantLock();
    }

    public void withdraw(int value, String name) {
        lock.lock();
        int temp = balance;
        try {
            System.out.println("Thread executing = " + name);
            Thread.sleep(1000);
            temp -= value;
            Thread.sleep(1000);
            balance = temp;
            System.out.println("Current balance = " + balance);
        } catch (InterruptedException e) {

        }
        lock.unlock();
    }

    public void deposit(int value, String name) {
        lock.lock();
        int temp = balance;
        try {
            System.out.println("Thread executing = " + name);
            Thread.sleep(1000);
            temp += value;
            Thread.sleep(1000);
            balance = temp;
            System.out.println("Current balance = " + balance);
        } catch (InterruptedException e) {

        }
        lock.unlock();
    }
}
