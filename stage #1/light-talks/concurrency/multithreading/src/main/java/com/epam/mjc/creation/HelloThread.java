package com.epam.mjc.creation;

public class HelloThread extends Thread{

     @Override
     public void run() {
         // do smth
        System.out.println("Hello from "+Thread.currentThread().getName()
                + " created by "
                + "extending Thread class!");
    }

    
}
