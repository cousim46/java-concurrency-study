package lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockReadLockExample {

    public static void main(String[] args) {
        ReadWriteLock lock = new ReentrantReadWriteLock();
        lock.BankAccount bankAccount = new lock.BankAccount(lock, 0);
        // 읽기 쓰레드가 잔액을 조회
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                int balance = bankAccount.getBalance();
                System.out.println(Thread.currentThread().getId() + " - 현재 잔액: " + balance);
            }).start();
        }

        // 쓰기 쓰레드가 잔액을 조회
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                int depositAmount = (int) (Math.random() * 1000) + 1;
                bankAccount.deposit(depositAmount);
                System.out.println(Thread.currentThread().getId() + " - 입금: " + depositAmount);
            }).start();
        }

        // 읽기 쓰레드가 잔액을 조회
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                int balance = bankAccount.getBalance();
                System.out.println(Thread.currentThread().getId() + " - 현재 잔액: " + balance);
            }).start();
        }

    }

    static class BankAccount {

        ReadWriteLock lock;
        Map<String, Integer> balance = new HashMap<>();

        public BankAccount(ReadWriteLock readWriteLock) {
            lock = readWriteLock;
            balance.put("account1", 0);
        }

        public int getBalance() {
            lock.readLock().lock();
            try {
                Thread.sleep(1000);
                return balance.get("account1");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.readLock().unlock();
            }
        }
    }
}
