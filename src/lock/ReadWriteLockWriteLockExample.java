package lock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockWriteLockExample {

    public static void main(String[] args) {
        ReadWriteLock lock = new ReentrantReadWriteLock();
        BankAccount bankAccount = new BankAccount(lock, 10000);
        // 읽기 쓰레드가 잔액을 조회
            new Thread(() -> {
                int balance = bankAccount.getBalance();
                System.out.println(Thread.currentThread().getId() + " - 현재 잔액: " + balance);
            }).start();

        // 쓰기 쓰레드가 잔액을 조회
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                int withdrawAmount = (int) (Math.random() * 1000) + 1;
                bankAccount.withdraw(withdrawAmount);
                System.out.println(Thread.currentThread().getId() + "- 출금" + withdrawAmount);
            }).start();
        }

        // 읽기 쓰레드가 잔액을 조회
            new Thread(() -> {
                int balance = bankAccount.getBalance();
                System.out.println(Thread.currentThread().getId() + " - 현재 잔액: " + balance);
            }).start();
    }
}
