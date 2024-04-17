package interrupt;

public class InterruptedExample2 {

    public static void main(String[] args) {
        Thread thread2 = new Thread(() -> {
            while(!Thread.interrupted()) {
                System.out.println("스레드2가 작동 중입니다..");
            }
            System.out.println("인터럽트 상태 : " + Thread.currentThread().isInterrupted());
        });

        Thread thread1 = new Thread(() -> {
            for(int i = 0; i < 5; i++) {
                System.out.println("스레드 1 작동중");
                if(i == 2) {
                    thread2.interrupt();
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {

                }
            }
        });

        thread1.start();
        thread2.start();

        System.out.println("main");
    }

}
