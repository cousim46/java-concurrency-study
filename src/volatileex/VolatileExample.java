package volatileex;

public class VolatileExample {
    private  int count = 0;
    
    public synchronized void increase() {
        count++;
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileExample volatileExample = new VolatileExample();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                volatileExample.increase();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                volatileExample.increase();
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("volatileExample.getCount() = " + volatileExample.getCount());
    }

}
