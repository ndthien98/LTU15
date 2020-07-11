/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author DungNT
 */
public class JavaApplication2 {

    private static Future taskTwo = null;
    private static Future taskThree = null;
    public static int i = 0;
    public static Integer it = new Integer(0);
    
    /**
     * @param args the command line arguments
     */
    
    public static void increase(int id)
    {
        synchronized(it)
        {
            for(int k=1;k<100;k++)
                    JavaApplication2.i++;
            System.out.println("id " + id + " i= " + JavaApplication2.i);
        }
    }
    
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // TODO code application logic here
        /*Thread t1 = new MyThread(1);
        t1.start();
        Thread t2 = new MyThread(2);
        t2.start();
        Thread t3 = new MyThread(3);
        t3.start();*/
        MyTask task1 = new MyTask(1);
        MyTask task2 = new MyTask(2);
        MyTask task3 = new MyTask(3);
        Thread t1 = new Thread(task1);
        t1.start();
        Thread t2 = new Thread(task2);
        t2.start();
        Thread t3 = new Thread(task3);
        t3.start();
        /*ExecutorService executor = Executors.newFixedThreadPool(2);
        // execute the Runnable
        Runnable taskOne = new MyTask(1);
        executor.execute(taskOne);
        for(int i = 0; i < 10; i++) {
            // if this task is not created or is canceled or is completed
            if ((taskTwo == null) || (taskTwo.isDone()) || (taskTwo.isCancelled())) {
                // submit a task and return a Future
                taskTwo = executor.submit(new MyTask(2));
            }

            if ((taskThree == null) || (taskThree.isDone()) || (taskThree.isCancelled())) {
                taskThree = executor.submit(new MyTask(3));
            }

            // if null the task has finished
            if(taskTwo.get() == null) {
                System.out.println(i+" TaskTwo terminated successfully");
            } else {
                // if it doesn't finished, cancel it
                System.out.println(i+" TaskTwo cancelled successfully");
                taskTwo.cancel(true);
            }

            if(taskThree.get() == null) {
                System.out.println(i+" TaskThree terminated successfully");
            } else {
                System.out.println(i+" TaskThree cancelled successfully");
                taskThree.cancel(true);
            }
        }

        executor.shutdown();

        System.out.println("-----------------------");
        // wait until all tasks are finished
        executor.awaitTermination(1, TimeUnit.SECONDS);
        System.out.println("All tasks are finished!");
        */
    }
}
