package thread;

public class TerminatedStateThreadExample {

    public static void main(String[] args) throws InterruptedException {
        
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("스레드 실행중");
            }
        });
        thread.start();
        thread.join();
        System.out.println("thread.getState() = " + thread.getState());
    }

}
