package practice.threads;

/**
 * Thread withdraws money from account
 *
 * @author Yashraj R. Sontakke
 */
public class MyAtmWithdrawThread extends Thread {
    public String name;
    public LockedAtm lockedAtm;

    public MyAtmWithdrawThread(final LockedAtm lockedAtm, final String name) {
        this.lockedAtm = lockedAtm;
        this.name = name;
    }

    @Override
    public void run() {
        lockedAtm.withdraw(50, name);
    }

    public static void main(String[] args) throws InterruptedException {

        // Same reference of MyObject, waiting
        LockedAtm myObject = new LockedAtm();
        MyAtmWithdrawThread thread1 = new MyAtmWithdrawThread(myObject, "3");
        MyAtmWithdrawThread thread2 = new MyAtmWithdrawThread(myObject, "4");
        thread1.start();
        thread2.start();
    }
}
