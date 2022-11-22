package com.epam.mjc.join;

public class TestJoin extends Thread {

    //Constructor to assign a user defined name to the thread
    public TestJoin(String name)
    {
        super(name);
    }

    public void run(){
        for(int i=1;i<=5;i++){  
        try{
            //stop the thread for 1/2 second
            Thread.sleep(500);  
            }
        catch(Exception e){System.out.println(e);}  
        System.out.println(Thread.currentThread().getName()+
                " i = "+i);  
        }  
     }
}

