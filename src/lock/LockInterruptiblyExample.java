package lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockInterruptiblyExample {

    public static void main(String[] args) throws InterruptedException {

        Lock lock = new ReentrantLock();

        Thread thread1 = new Thread(() -> {
            try {
                lock.lockInterruptibly();
                try{
                    System.out.println("스레드 1이 락 획득");
                }finally {
                    lock.unlock();
                    System.out.println("스레드1이 락 해제");
                }
            } catch (InterruptedException e) {
                System.out.println("스레드 1 인터럽트를 받음");
            }
        });



        Thread thread2 = new Thread(() -> {
            try {
                lock.lockInterruptibly();
                try{
                System.out.println("스레드 2이 락 획득");
                }finally {
                    lock.unlock();
                    System.out.println("스레드2이 락 해제");
                }
            } catch (InterruptedException e) {
                System.out.println("스레드 2 인터럽트를 받음");
            }
        });

        thread1.start();
        thread2.start();

        thread1.interrupt();
        thread2.interrupt();

        thread1.join();
        thread2.join();

    }

}
