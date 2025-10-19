package lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;

public class BankAccount {
    private ReadWriteLock lock;
    private Map<String, Integer> balance = new HashMap<>();

    public BankAccount(ReadWriteLock readWriteLock, int amount) {
        lock = readWriteLock;
        balance.put("account1", amount);
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


    public void deposit(int amonut) {
        lock.writeLock().lock();
        try {
            Thread.sleep(2000);
            int currentBalance = balance.get("account1");
            currentBalance += amonut;
            balance.put("account1", currentBalance);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void withdraw(int amonut) {
        lock.writeLock().lock();
        try {
            Thread.sleep(2000);
            int currentBalance = balance.get("account1");
            System.out.println("현재 잔액 : " + currentBalance);
            if(currentBalance >= amonut) {
                currentBalance -= amonut;
                balance.put("account1", currentBalance);
                System.out.println(Thread.currentThread().getName() + " - 출금 성공");
            }else {
                System.out.println(Thread.currentThread().getName() + " - 출금 실패, 잔액 부족");
            }
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.writeLock().unlock();
        }
    }

}
