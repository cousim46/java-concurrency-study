package semaphore;

public class BinarySemaphoreExample {

	public static void main(String[] args) throws InterruptedException {
		SemaPhoreShareData shareData = new SemaPhoreShareData(new BinarySemaphore());
		Thread thread1 = new Thread(() -> {
			shareData.sum();
		});
		Thread thread2 = new Thread(() -> {
			shareData.sum();
		});

		thread1.start();
		thread2.start();
		thread1.join();
		thread2.join();

		System.out.println(shareData.getSharedValue());
	}

}

class SemaPhoreShareData {

	private int sharedValue = 0;
	private CommonSemaphore commonSemaphore;

	public SemaPhoreShareData(CommonSemaphore commonSemaphore) {
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
