/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package producerandconsumer;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DungNT
 */
public class Client extends Thread{
    public int idclient;
    
    public Client(int id)
    {
        idclient = id;
    }
    
    public void run()
    {
        
        while(true)
        {
            synchronized(ProducerAndConsumer.queue)
            {
                Message m = new Message(++ProducerAndConsumer.id);
                System.out.println("Client " + idclient +" vua cho vao queue message có id " + m.getId());
                ProducerAndConsumer.queue.add(m);
                ProducerAndConsumer.queue.notifyAll();                
            }
            
            try {
                this.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
