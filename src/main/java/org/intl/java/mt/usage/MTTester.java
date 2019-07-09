package org.intl.java.mt.usage;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class MTTester {

	public static void main(String[] a) {
		MTTester tester = new MTTester();
		tester.runWithThreadPoolExecutor();
		tester.runWithStartMethod();
	}

	/**
	 * Create a pool with 'N' number of threads.
	 */
	private void runWithThreadPoolExecutor() {
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
		for (int num = 0; num < 40; num++) {
			MTUsingThread obj = new MTUsingThread();
			obj.setNum(num);
			executor.execute(obj);
		}
		System.out.println("Active threads:" + executor.getActiveCount());
		System.out.println("Completed tasks:" + executor.getCompletedTaskCount());
		executor.shutdown();
	}

	/**
	 * Typical implementation of a thread in java
	 */
	private void runWithStartMethod() {
		for (int num = 0; num < 40; num++) {
			MTUsingRunnable obj = new MTUsingRunnable();
			obj.setNum(num);
			new Thread(obj).start();
		}
	}
}
