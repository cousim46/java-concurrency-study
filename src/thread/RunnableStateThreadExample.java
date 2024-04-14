package thread;

public class RunnableStateThreadExample {

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    for(int i = 0; i < 100000000; i++) {
                        if(i % 100000000 == 0) {
                            System.out.println("스레드 상태 : " + Thread.currentThread().getState());
                        }
                    }
                }
            }
        });
        thread.start();
    }
}
