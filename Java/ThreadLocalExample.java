public class ThreadLocalExample {

	public static class MyRunnable implements Runnable {

		// All thread will get all its set values, if no value has been set then
		// we can override initialValue method of ThreadLocal to initialize
		// default value.
		private final ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

		@Override
		public void run() {
			threadLocal.set((int) (Math.random() * 100D));
			System.out.println(Thread.currentThread().getName()
					+ " Integer value before sleep : " + threadLocal.get());

			try {
				Thread.sleep(2000);
			} catch (final InterruptedException e) {
			}

			System.out.println(Thread.currentThread().getName()
					+ " Integer value after sleep : " + threadLocal.get());
		}
	}

	public static void main(final String[] args) throws InterruptedException {
		final MyRunnable sharedRunnableInstance = new MyRunnable();

		final Thread thread1 = new Thread(sharedRunnableInstance);
		thread1.setName("Thread 1");
		final Thread thread2 = new Thread(sharedRunnableInstance);
		thread2.setName("Thread 2");

		thread1.start();
		thread2.start();

		thread1.join(); // wait for thread 1 to terminate
		thread2.join(); // wait for thread 2 to terminate
	}

}
