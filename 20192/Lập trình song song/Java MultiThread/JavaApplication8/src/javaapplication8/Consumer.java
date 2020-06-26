/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication8;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dungnt
 */
public class Consumer extends Thread {

    public static Object objwait = new Object();
    public String name;
    private int size;

    public Consumer(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        do {
            synchronized (Client.queue) {
                size = Client.queue.size();
            }
            if (size == 0) {
                try {
                    synchronized (objwait) {
                        objwait.wait();
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                synchronized (Client.queue) {
                    if (!Client.queue.isEmpty()) {
                        System.out.println(name + " phuc vu " + Client.queue.get(0));
                        Client.queue.remove(0);
                    }
                }
            }
        } while (true);
    }
}
