public class UncaughtExceptionHandlerExample {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		final Thread.UncaughtExceptionHandler handler = new Thread.UncaughtExceptionHandler() {

			@Override
			public void uncaughtException(final Thread t, final Throwable e) {
				System.out.println("Uncaught exception: " + e);
			}
		};

		final Thread otherThread = new Thread() {
			@Override
			public void run() {
				System.out.println("Sleeping ...");

				try {
					Thread.sleep(1000);
				} catch (final InterruptedException e) {
					System.out.println("Interrupted.");
				}
				System.out.println("Throwing exception ...");
				throw new RuntimeException();
			}
		};

		otherThread.setUncaughtExceptionHandler(handler);
		// If we keep below statement in try-catch then it won't catch the
		// exception that's why we need separate code to catch the exception
		otherThread.start();

	}
}
