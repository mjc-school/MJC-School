package com.epam.mjc.threadgroup;

import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class ThreadGroupDemo {

    public static void main(String[] args) throws InterruptedException {
        // creating the thread group
        ThreadGroup gfg = new ThreadGroup("parent thread group");

        ThreadGroup gfgChild = new ThreadGroup(gfg, "child");

        NewThread t1 = new NewThread("one", gfg);
        log.info("Starting one");
        NewThread t2 = new NewThread("two", gfg);
        log.info("Starting two");



        // checking the number of active thread
        log.info("number of active thread: {}", gfg.activeCount());

        gfg.getParent();

        log.info("The parent is  {}", gfg.getParent());

        gfgChild.getParent();
        log.info("The child group's parent {}", gfgChild.getParent());

        gfgChild.list();
        gfg.list();
        Thread.sleep(2000);
        gfg.interrupt();

    }
}

@Slf4j
class NewThread extends Thread
{
    NewThread(String threadName, ThreadGroup tgob)
    {
        super(tgob, threadName);
        start();
    }
    @Override
    public void run()
    {

        for (int i = 0; i < 1000; i++)
        {
            try
            {
                Thread.sleep(10);
            }
            catch (InterruptedException ex)
            {
                log.info("Exception encounterted");
            }
        }
    }
}
