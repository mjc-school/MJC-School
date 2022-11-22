package com.epam.mjc.join;

public class ThreadJoin {

    public static void main(String[] args) {
        TestJoin t1 = new TestJoin("t1");
        TestJoin t2 = new TestJoin("t2");
        TestJoin t3 = new TestJoin("t3");
        t1.start();  
        try{  
            t1.join();  
        }catch(Exception e){System.out.println(e);}  
        t2.start(); 
        //thread 3 won't start until thread 2 is complete
        t3.start();  
    }
    
}
