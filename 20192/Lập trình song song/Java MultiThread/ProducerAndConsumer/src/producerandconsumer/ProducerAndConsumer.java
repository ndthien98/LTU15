/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package producerandconsumer;

import java.util.Vector;

/**
 *
 * @author DungNT
 */
public class ProducerAndConsumer {
    public static Vector<Message> queue = new Vector<Message>();
    public static int id = -1;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Client c1 = new Client(1);
        c1.start();
        Client c2 = new Client(2);
        c2.start();
        Client c3 = new Client(3);
        c3.start();
        Client c4 = new Client(4);
        c4.start();
        Client c5 = new Client(5);
        c5.start();
        Server s1 = new Server(1);
        s1.start();
        Server s2 = new Server(2);
        s2.start();
        Server s3 = new Server(3);
        s3.start();
        Server s4 = new Server(4);
        s4.start();
        Server s5 = new Server(5);
        s5.start();
        Server s6 = new Server(6);
        s6.start();
        Server s7 = new Server(7);
        s7.start();
        Server s8 = new Server(8);
        s8.start();
        Server s9 = new Server(9);
        s9.start();
    }
}
