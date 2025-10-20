package monitor;

public class ConditionSynchronizationExample {
	private boolean isAvailable = false;

	public synchronized void produce() {
		System.out.println(Thread.currentThread().getName());
		while(isAvailable) {
			try {
				wait(); // wait-set에 드렁감
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		System.out.println("생산 됨");
		isAvailable = true;
		notify();
	}

	public synchronized  void consume() {
		System.out.println(Thread.currentThread().getName());
		while(!isAvailable) {
			try {
				wait();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		System.out.println("소비 됨");
		isAvailable = false;
		notify();
	}
	public static void main(String[] args) {
		ConditionSynchronizationExample example = new ConditionSynchronizationExample();

		new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				example.produce();
			}
		}, "produceThread").start();

		new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				example.consume();
			}
		}, "consumeThread").start();
	}

}
