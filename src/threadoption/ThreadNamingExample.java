package threadoption;

public class ThreadNamingExample {

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("현재 스래드 이름 : " + Thread.currentThread().getName());
        }, "myThread").start();
        Thread yourThread = new Thread(() -> {
            System.out.println("현재 스래드 이름 : " + Thread.currentThread().getName());
        });
        yourThread.setName("yourThread");
        yourThread.start();

        for(int i = 0; i < 5; i++) {
            new Thread(() ->{
                System.out.println("현재 스래드 이름 : " + Thread.currentThread().getName());
            }
                ).start();
        }
    }
}
