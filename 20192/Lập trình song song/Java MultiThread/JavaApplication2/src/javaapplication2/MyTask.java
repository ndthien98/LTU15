/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

/**
 *
 * @author DungNT
 */
public class MyTask implements Runnable{
    private int taskId;

    MyTask(int i) {
        taskId = i;
    }
    
    @Override
    public void run() {
        if(taskId==1)
        {
            System.out.println("");
            for(int i=1;i<5000;i++)
                System.out.printf("a");
            System.out.println("");
            //JavaApplication2.increase(taskId);
        }
        else if(taskId==2)
        {
            System.out.println("");
            int k=0;
            for(int i=1;i<5000;i++)
                //k++;
                System.out.printf("b");
            System.out.println("");
            //JavaApplication2.increase(taskId);
        }
        else if(taskId==3)
        {
            System.out.println("");
            int k=0;
            for(int i=1;i<5000;i++)
                //k++;
                System.out.printf(""+i);
            System.out.println("");
            //JavaApplication2.increase(taskId);
        }
        
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
