package thread;

public class NewStateThreadExample {

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("스레드 실행중");
            }
        });

        System.out.println("스레드 상태 : " + thread.getState()); // NEW

    }

}
