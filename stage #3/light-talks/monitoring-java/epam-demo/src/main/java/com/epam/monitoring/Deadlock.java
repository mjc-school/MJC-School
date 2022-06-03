package com.epam.monitoring;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Deadlock {

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lockA = new ReentrantLock();
        ReentrantLock lockB = new ReentrantLock();

        LockingThread thread1 = new LockingThread(lockA, lockB);
        LockingThread thread2 = new LockingThread(lockB, lockA);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }

    private static class LockingThread extends Thread {

        private final Lock lock1;
        private final Lock lock2;

        private LockingThread(Lock lock1, Lock lock2) {
            this.lock1 = lock1;
            this.lock2 = lock2;
        }

        @Override
        public void run() {
            lock1.lock();
            try {
                System.out.println(Thread.currentThread().getName() + ") locked " + lock1);
                Thread.sleep(3_000);

                lock2.lock();
                try {
                    System.out.println(Thread.currentThread().getName() + ") locked " + lock2);
                } finally {
                    lock2.unlock();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock1.unlock();
            }
        }
    }
}
