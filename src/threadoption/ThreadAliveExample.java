package threadoption;

public class ThreadAliveExample {

    public static void main(String[] args) {
        Thread task1 = new Thread(() -> {
            for(int i = 0; i < 5; i++) {
                System.out.println("작업 스레드 1 실행중");
                try {
                    Thread.sleep(100); //100ms 동안 일시 정지
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread task2 = new Thread(() -> {
            for(int i = 0; i < 5; i++) {
                System.out.println("작업 스레드 2 실행중");
                try {
                    Thread.sleep(150); //150ms 동안 일시 정지
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        task1.start();
        task2.start();
        while(task1.isAlive() || task2.isAlive()) {
            System.out.println("작업 스레드1 상태 : " + task1.isAlive());
            System.out.println("작업 스레드2 상태 : " + task2.isAlive());
        }
        System.out.println("모든 스레드가 완료");
    }

}
