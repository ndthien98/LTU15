/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmstopicproject;

/**
 *
 * @author thiennd
 */

import javax.jms.*;

public class MyListener implements MessageListener {

    public void onMessage(Message m) {
        try {
            TextMessage msg = (TextMessage) m;
            System.out.println("following message is received:" + msg.getText());
        } catch (JMSException e) {
            System.out.println(e);
        }
    }
}
