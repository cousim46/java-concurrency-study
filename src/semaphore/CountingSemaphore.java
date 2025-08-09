package semaphore;

public class CountingSemaphore implements CommonSemaphore{
	private int signal;
	private int perimits;

	public CountingSemaphore(int perimits) {
		this.perimits = perimits;
		this.signal = perimits;
	}

	@Override
	public synchronized void acquired() {
		while(signal == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		this.signal--;
		System.out.println(Thread.currentThread().getName() + " 락 획득, 현재 세마포어 값 : " + signal);
	}

	@Override
	public synchronized void release() {
		if(this.signal < perimits) {
			this.signal++;
			System.out.println(Thread.currentThread().getName() + " 락 해제, 현재 세마포어 값 : " + signal);
			this.notify();
		}
	}
}
