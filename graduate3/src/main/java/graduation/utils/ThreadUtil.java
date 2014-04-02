package graduation.utils;

public class ThreadUtil {
	public static void startThread(Runnable run) {
		Thread thread = new Thread(run);
		thread.start();
	}
}
