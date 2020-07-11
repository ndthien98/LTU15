/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication8;

/**
 *
 * @author dungnt
 */
public class Thread_Test extends Thread {
        private int i;
        private String threadname;

        public Thread_Test(int i, String threadname) {
            this.i = i;
            this.threadname = threadname;
        }

        @Override
        public void run() {
            do {
                System.out.println("luong " + threadname + " i: " + (++i));
            } while (true);
        }
    }
