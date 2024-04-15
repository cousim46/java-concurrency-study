package threadapi.join;

public class BasicJoinExample {

    public static void main(String[] args)  {
        Thread thread = new Thread(() -> {
            try {
                System.out.println("스레드가 3초동안 작동합니다.");
                Thread.sleep(3000);
                System.out.println("스레드 작동 완료.");
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("main 스레드 끝");

    }
}
