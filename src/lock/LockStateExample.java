package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockStateExample {

    private static final Lock lock1 = new ReentrantLock();

    public static void main(String[] args) {
        new Thread(() -> {
            lock1.lock();
            try{
                System.out.println("스레드가 첫번째 락을 획득");
                lock1.lock();
                try {
                    System.out.println("스레드가 두번째 락을 획득");
                    lock1.lock();
                    try {
                        System.out.println("스레드가 세번째 락을 획득");
                    }finally {
                        System.out.println("스레드가 세번째 락을 해제");
                        lock1.unlock();
                    }
                }finally {
                    System.out.println("스레드가 두번째 락을 해제");
                    lock1.unlock();
                }

            }finally {
                System.out.println("스레드가 첫번째 락을 해제");
                lock1.unlock();
            }
        }).start();

        new Thread(() -> {
            lock1.lock();
            try{
                System.out.println("스레드 2가 락을 획득");
            }finally {
                System.out.println("스레드 2가 락을 해제");
                lock1.unlock();
            }
        }).start();
    }

}

