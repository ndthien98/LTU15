/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author DungNT
 */
public class JavaApplication1  {

    /**
     * @param args the command line arguments
     */
    private static Future taskTwo = null;
    private static Future taskThree = null;

    
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // TODO code application logic here
        //ClassThread ct = new ClassThread();
        //ct.start();
        //Thread t = new Thread(new ClassTask());
        //t.start();
        //---------------------------------
        ExecutorService executor = Executors.newFixedThreadPool(2);
        // execute the Runnable
        Runnable taskOne = new ClassExecutorTask("TaskOne", 2, 100);
        executor.execute(taskOne);
        for(int i = 0; i < 2; i++) {
            // if this task is not created or is canceled or is completed
            if ((taskTwo == null) || (taskTwo.isDone()) || (taskTwo.isCancelled())) {
                // submit a task and return a Future
                taskTwo = executor.submit(new ClassExecutorTask("TaskTwo", 4, 200));
            }

            if ((taskThree == null) || (taskThree.isDone()) || (taskThree.isCancelled())) {
                taskThree = executor.submit(new ClassExecutorTask("TaskThree", 5, 100));
            }

            // if null the task has finished
            if(taskTwo.get() == null) {
                System.out.println(i+1 + ") TaskTwo terminated successfully");
            } else {
                // if it doesn't finished, cancel it
                taskTwo.cancel(true);
            }

            if(taskThree.get() == null) {
                System.out.println(i+1 + ") TaskThree terminated successfully");
            } else {
                taskThree.cancel(true);
            }
        }

        executor.shutdown();

        System.out.println("-----------------------");
        // wait until all tasks are finished
        executor.awaitTermination(1, TimeUnit.SECONDS);
        System.out.println("All tasks are finished!");
    }
}
