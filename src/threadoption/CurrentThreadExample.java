package threadoption;

public class CurrentThreadExample {

    public static void main(String[] args) {

        System.out.println("현재 스레드 : " + Thread.currentThread());
        System.out.println("현재 스레드이름 : " + Thread.currentThread().getName());

        new Thread() {
            @Override
            public void run() {
                System.out.println("현재 스레드 : " + Thread.currentThread());
                System.out.println("현재 스레드 : " + getName());
            }
        }.start();
        new Thread(new ThreadName()).start();

    }
}
class ThreadName implements Runnable {

    @Override
    public void run() {
        System.out.println("현재 스레드 : " + Thread.currentThread());
        System.out.println("Runnavle 현재 스레드이름 : " + Thread.currentThread().getName());
    }
}
