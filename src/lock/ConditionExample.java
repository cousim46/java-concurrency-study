package lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionExample {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private boolean flag = false;

    public void awaitng() throws InterruptedException {
        lock.lock();
        try {
            while (!flag) {
                System.out.println("조건이 만족하지 못해 대기");
                condition.await();
                System.out.println("컨디션");
            }
            System.out.println("임계영역 수행");
        } finally {
            lock.unlock();
        }
    }

    public void signaling() {
        lock.lock();
        try {
            flag = true;
            System.out.println("조건을 만족시키고 깨움");
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ConditionExample conditionExample = new ConditionExample();

        Thread thread1 = new Thread(() -> {
            try {
                conditionExample.awaitng();
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        });

        Thread thread2 = new Thread(conditionExample::signaling);

        thread1.start();
        Thread.sleep(2000);
        thread2.start();

        thread1.join();
        thread2.join();
    }

}
