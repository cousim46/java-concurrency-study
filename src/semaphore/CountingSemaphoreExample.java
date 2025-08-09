package semaphore;

import java.util.concurrent.Semaphore;

public class CountingSemaphoreExample {

	public static void main(String[] args) throws InterruptedException {
		int permits = 10;
		SemaPhoreShareData2 shareData = new SemaPhoreShareData2(new CountingSemaphore(permits));
		int threadCount = 15;
		Thread[] threads = new Thread[threadCount];
		for (int i = 0; i < threads.length; i++) {
			Thread thread = new Thread(() -> {
				shareData.sum();
			}, "thread" + i);
			threads[i] = thread;

			threads[i].start();
		}
		for (int i = 0; i < threads.length; i++) {
			threads[i].join();
		}

		System.out.println(shareData.getSharedValue());
	}

}

class SemaPhoreShareData2 {

	private int sharedValue = 0;
	private CommonSemaphore commonSemaphore;

	public SemaPhoreShareData2(CommonSemaphore commonSemaphore) {
		this.commonSemaphore = commonSemaphore;
	}

	public void sum() {
		try {
			commonSemaphore.acquired();
			for (int i = 0; i < 10000000; i++) {
				sharedValue++;
			}
		}finally {
			commonSemaphore.release();
		}
	}

	public int getSharedValue() {
		return sharedValue;
	}

}
