package com.epam.mjc.demo;

/**
 * Demo that shows usage of {@code ThreadGroup} class.
 */
public class Demo6 {

    public static void main(String[] args) throws InterruptedException {
        ThreadGroup mainGroup = new ThreadGroup("mainGroup");
        ThreadGroup groupA = new ThreadGroup(mainGroup, "Group A");
        ThreadGroup groupB = new ThreadGroup(mainGroup, "Group B");
        MyThread ob1 = new MyThread("One", groupA);
        MyThread ob2 = new MyThread("Two", groupA);
        MyThread ob3 = new MyThread("Three", groupB);
        MyThread ob4 = new MyThread("Four", groupB);

        groupA.list();
        groupB.list();

        Thread.sleep(2000);

        mainGroup.interrupt();
    }

    static class MyThread extends Thread {

        public MyThread(String threadname, ThreadGroup tgOb) {
            super(tgOb, threadname);
            System.out.println("New thread: " + this);
            start();
        }
        public void run() {
            try {
                for (int i = 5; i > 0; i--) {
                    System.out.println(getName() + ": " + i);
                    Thread.sleep(1000);
                }
            } catch (Exception e) {
                System.out.println("Exception in " + getName());
            }
            System.out.println(getName() + " exiting.");
        }
    }


}
