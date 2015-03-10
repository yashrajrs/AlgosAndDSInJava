package practice.threads;

/**
 * Thread deposits money to account.
 *
 * @author Yashraj R. Sontakke
 */
public class MyAtmDepositThread extends Thread {
    public String name;
    public LockedAtm lockedAtm;

    public MyAtmDepositThread(final LockedAtm lockedAtm, final String name) {
        this.lockedAtm = lockedAtm;
        this.name = name;
    }

    @Override
    public void run() {
        lockedAtm.deposit(100, name);
    }


}
