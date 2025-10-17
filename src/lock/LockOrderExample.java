package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockOrderExample {

    private static final Lock lock1 = new ReentrantLock();
    private static final Lock lock2 = new ReentrantLock();

    public static void main(String[] args) {
        new Thread(() -> {
            lock1.lock();
            try{
                System.out.println("스레드가 1번 락을 획득");
                lock2.lock();
                try{
                    System.out.println("스레드가 2번 락을 획득");
                }finally {
                    lock1.unlock();
                    System.out.println("스레드가 1번 락을 해제");
                }
            }finally {
                lock2.unlock();
                System.out.println("스레드가 2번 락을 해제");
            }
        }).start();
    }

}
