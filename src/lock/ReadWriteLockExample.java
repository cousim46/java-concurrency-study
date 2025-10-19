package lock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {

    public static void main(String[] args) {
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        ShareData shareData = new ShareData();
        Thread reader = new Thread(() -> {
            readWriteLock.readLock().lock();
            try {
                System.out.println("읽기 스레드가 데이터를 읽고 있습니다 : " + shareData.getData());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } finally {
                readWriteLock.readLock().unlock();
            }
        });

        Thread reader2 = new Thread(() -> {
            readWriteLock.readLock().lock();
            try {
                System.out.println("읽기 스레드2가 데이터를 읽고 있습니다 : " + shareData.getData());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } finally {
                readWriteLock.readLock().unlock();
            }
        });

        Thread writer = new Thread(() -> {
            readWriteLock.writeLock().lock();
            try {
                System.out.println("쓰기 스레드가 데이터를 쓰고 있습니다");
                shareData.setData(40);
                System.out.println("쓰기 스레드가 데이터를 변경 했습니다. : "  + shareData.getData());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } finally {
                readWriteLock.writeLock().unlock();
            }
        });

        writer.start();
        reader.start();
        reader2.start();
    }

    static class ShareData {

        private int data = 0;

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }
    }

}
