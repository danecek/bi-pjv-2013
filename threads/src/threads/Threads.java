/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

/**
 *
 * @author danecek
 */
public class Threads {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        System.out.println(Thread.currentThread());
//        Thread.dumpStack();
//        System.out.println(Thread.currentThread().getPriority());
        new MyThread("MojeVlakno1").start();
        new MyThread("MojeVlakno2").start();
        new MyThread("MojeVlakno3").start();
        new MyThread("MojeVlakno4").start();

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Jiny thread");

            }
        });
        t.start();
        // TODO code application logic here
    }
}
