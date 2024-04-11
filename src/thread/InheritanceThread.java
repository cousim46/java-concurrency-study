package thread;

/**
 * 1) Thread 클래스 상속
 * 2) run() 메서드 오버라이딩
 * 3) start() 메서드 실행
 * */
public class InheritanceThread extends Thread{

    @Override
    public void run() {
        //작업 내용
    }

    public static void main(String[] args) {
        Thread inheritanceThread = new InheritanceThread();
        inheritanceThread.start();

        // Thread 익명 클래스
        new Thread() {
            @Override
            public void run() {
                super.run();
            }
        }.start();


    }
}
