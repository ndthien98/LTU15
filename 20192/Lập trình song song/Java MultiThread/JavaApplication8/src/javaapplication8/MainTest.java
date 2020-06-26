/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication8;

import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dungnt
 */
public class MainTest {

    /**
     * @param args the command line arguments
     */
//    public static Queue c = new ConcurrentLinkedQueue<Integer>();
//    public static AtomicInteger a = new AtomicInteger(0);

    public static void main(String[] args) {
        // TODO code application logic here
        Client.init();
        
        Producer p = new Producer();
        p.start();

        Consumer c1 = new Consumer(" Consumer 1 ");
        c1.start();
        Consumer c2 = new Consumer(" Consumer 2 ");
        c2.start();
        Consumer c3 = new Consumer(" Consumer 3 ");
        c3.start();
    }




//    static class Thread_In extends Thread {
//
//        @Override
//        public void run() {
//            do {
//                System.out.println(" in ra " + a.get());
//                try {
//                    sleep(10000);
//                } catch (InterruptedException ex) {
//                    Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            } while (true);
//        }
//    }
}
