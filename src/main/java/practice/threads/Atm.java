package practice.threads;

/**
 * ATM example
 *
 * @author Yashraj R. Sontakke
 */
public class Atm {
    public static void main(String[] args) throws InterruptedException {

        // Same reference of MyObject, waiting
        LockedAtm myObject = new LockedAtm();
        MyAtmDepositThread thread1 = new MyAtmDepositThread(myObject, "1");
        MyAtmWithdrawThread thread2 = new MyAtmWithdrawThread(myObject, "2");
        thread1.start();
        thread2.start();
        thread1.run();
        thread2.run();
    }
}
