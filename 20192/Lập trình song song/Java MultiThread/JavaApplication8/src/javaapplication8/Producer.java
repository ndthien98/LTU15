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
public class Producer extends Thread {

    private int i;

    @Override
    public void run() {
        do {
            synchronized (Client.queue) {
                System.out.println(" Khach hang moi " + (++i));
                Client.queue.add(i);
            }

            synchronized (Consumer.objwait) {
                Consumer.objwait.notifyAll();
            }
            try {
                sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (true);
    }
}
