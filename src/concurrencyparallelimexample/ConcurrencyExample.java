package concurrencyparallelimexample;

import java.util.ArrayList;
import java.util.List;

public class ConcurrencyExample {

    public static void main(String[] args) {
        //int cpuCores = Runtime.getRuntime().availableProcessors() * 2;
        int cpuCores = 4;

        System.out.println("cpuCores = " + cpuCores);
        //CPU 개수만큼 데이터를 생성
        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < cpuCores; i++) {
            data.add(i);
        }

        //CPU개수만큼 데이터를 병렬 처리
        long startTime1 = System.currentTimeMillis();

        long sum1 = data.parallelStream()
            .mapToLong(i -> {
                try {
                    System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
                    Thread.sleep(1000);
                }catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return (long) i * i;
            }).sum();
        System.out.println("startTime1 = " + (System.currentTimeMillis() -startTime1));
        System.out.println("sum1 = " + sum1);

    }
}
