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
public class Server extends Thread {
    public int idserver;
    
    Server(int id)
    {
        idserver = id;
    }
    
    public void run()
    {
        while(true)
        {
            Message m = null;
            synchronized(ProducerAndConsumer.queue)
            {
                if(ProducerAndConsumer.queue.isEmpty())
                    try {
                        ProducerAndConsumer.queue.wait();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    }
                else
                {
                     m = ProducerAndConsumer.queue.remove(0);
                }
            }
            
            if(m!=null) 
            {
                System.out.println("Server " + idserver + " vua xu ly goi tin co id " + m.getId());
            }
            
        }
    }
}
