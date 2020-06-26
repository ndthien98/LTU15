/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package producerandconsumer;

/**
 *
 * @author DungNT
 */
public class Message {
    private int id;
    Message(int id)
    {
        this.id = id;
    }
    
    int getId()
    {
        return id;
    }    
}
