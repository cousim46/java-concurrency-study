package threadapi.join;

public class MultiThreadJoinExample {

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            try {
                System.out.println("스레드1 1초동안 작동합니다.");
                Thread.sleep(1000);
                System.out.println("스레드1 작동 완료.");

            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                thread1.join();
                System.out.println("스레드2 2초동안 작동합니다.");
                Thread.sleep(2000);
                System.out.println("스레2 작동 완료.");
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread1.start();
        thread2.start();
        try {
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("메인은?");
    }

}
