package thread;

public class ThreadStartRunExample {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " : 스레드 실행중..");
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " : 스레드 실행중..");
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " : 스레드 실행중..");
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
        System.out.println("main");
    }
}
