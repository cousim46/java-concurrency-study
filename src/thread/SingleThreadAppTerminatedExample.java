package thread;

public class SingleThreadAppTerminatedExample {

    public static void main(String[] args) {
        int sum = 0;
        for(int i = 0; i < 1000; i++) {
            sum += i;

        }
        System.out.println("sum : " + sum);
    }

    static class MyRunnable implements Runnable {
        private final int threadId;
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ": 스레드 실행 중 ..");
            firstMethod(threadId);
        }

        private void firstMethod(int threadId) {
            int localValue = threadId + 100;
            secondMethod(localValue);
        }

        private void secondMethod(int localValue) {
            String objectRef = threadId + ": Hello World";
            System.out.println(Thread.currentThread().getName() + " : 스레드 Id : " +  threadId + ", localValue : " + localValue);
        }

        public MyRunnable(int threadId) {
            this.threadId = threadId;
        }
    }

}
