package per.util.url.hit;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Hit the given url 'N' number of times with 'M' parallel threads
 * @author U6062618
 *
 */
public class MultiThreadedURLHitter {

	private static String[] URLS = { "http://10.30.167.219:9200/summaryidx/_search?pretty=true&q=*:*&size=500",
			"http://10.30.167.219:9200/financialsidx/_search?pretty=true&q=*:*&size=500" };// "http://localhost:8282/app/",
	private static final int TOTAL_HITS = 100000;
	private static final int TOTAL_THREADS = 1000;

	public static void main(String[] a) throws IOException {
		MultiThreadedURLHitter obj = new MultiThreadedURLHitter();
		obj.hitRandomURL();
	}

	public void hitRandomURL() {
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(TOTAL_THREADS);
		int totalURLS = URLS.length;
		Date d = new Date();
		for (int i = 0; i < TOTAL_HITS; i++) {
			int randomNum = ThreadLocalRandom.current().nextInt(0, totalURLS);
			URLHitter urlHandler = new URLHitter();
			urlHandler.setUrl(URLS[randomNum]);
			executor.execute(urlHandler);
		}
		executor.shutdown();
		System.out.println("Total time taken: " + (new Date().getTime() - d.getTime()) + " msec");
	}

	private class URLHitter implements Runnable {

		private String url;

		public void run() {
			try {
				URL u = new URL(url);
				u.getContent();
				System.out.println("Thread name :" + Thread.currentThread().getName() + " Hit URL:" + url);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public String getUrl() {
			return this.url;
		}

		public void setUrl(String url) {
			this.url = url;
		}
	}
}