package threadapi.sleep;

public class InterruptSleepExample {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                System.out.println("20초 동안 잠듭니다. 인터럽트되지 않는다면 계속 잠들어 잇을것입니다.");

                Thread.sleep(20000);

                System.out.println("인터럽트 없이 잠에서 깨었습니다.");
            } catch (InterruptedException e) {
                System.out.println("잠들어 잇는 동안 인터럽트 되었습니다.");
            }
        });
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }

}
