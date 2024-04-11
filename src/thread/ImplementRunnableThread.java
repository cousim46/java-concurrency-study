package thread;

/**
 * 1) Runnable 인터페이스 구현
 * 2) run() 메서드 오버라이딩
 * 3) Thread 생성 시 생성자에 전달
 * 4) start() 메서드 실행
 * */
public class ImplementRunnableThread implements Runnable{

    @Override
    public void run() {
        //작업 내용
    }

    public static void main(String[] args) {
        Runnable runnable = new ImplementRunnableThread();
        Thread thread = new Thread(runnable);
        thread.start();
        //Ruunable 익명 클래스
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();

        //Ruunable 람다 형식
        new Thread(() -> {
            //작업 내용
        }).start();
    }
}
