/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

/**
 *
 * @author DungNT
 */
public class MyThread extends Thread {
    private int threadId;

    MyThread(int i) {
        threadId = i;
    }
    
    public void run()
    {
        if(threadId==1)
        {
            for(int i=1;i<101;i++)
                System.out.printf("a");
        }
        else if(threadId==2)
        {
            for(int i=1;i<101;i++)
                System.out.printf("b");
        }
        else if(threadId==3)
        {
            for(int i=1;i<101;i++)
                System.out.printf(""+i);
        }
    }
}
