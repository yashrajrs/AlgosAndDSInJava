package practice.threads;

/**
 * Created with IntelliJ IDEA.
 * User: yashrajsontakke
 * Date: 3/9/15
 * Time: 7:21 PM
 * To change this template use File | Settings | File Templates.
 *
 * @author Yashraj R. Sontakke
 */

public class MyObject{
    public synchronized void foo(String name){
        try{
            System.out.println("Thread started " + name);
            Thread.sleep(3000);
            System.out.println("Thread terminated " + name);
        }catch (InterruptedException e){
            System.out.println("Thread interrupted " + name);
        }
    }
}
