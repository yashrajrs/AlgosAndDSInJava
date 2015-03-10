package practice.threads;

/**
 * Synchronized methods.
 *
 * @author Yashraj R. Sontakke
 */
public class MyThread extends Thread{
    public String name;
    public MyObject myObject;

    public MyThread(final MyObject myObject, final String name){
        this.myObject = myObject;
        this.name = name;
    }

    @Override
    public void run(){
        myObject.foo(name);
    }

    public static void main(String[] args) throws InterruptedException {
        // Different references of MyObject, no waiting
        MyObject myObject1 = new MyObject();
        MyObject myObject2 = new MyObject();
        MyThread myThread1 = new MyThread(myObject1, "1");
        MyThread myThread2 = new MyThread(myObject2, "2");

        myThread1.start();
        myThread2.start();

        Thread.sleep(5000);

        // Same reference of MyObject, waiting
        MyObject myObject = new MyObject();
        MyThread thread1 = new MyThread(myObject, "3");
        MyThread thread2 = new MyThread(myObject, "4");
        thread1.start();
        thread2.start();
    }
}
