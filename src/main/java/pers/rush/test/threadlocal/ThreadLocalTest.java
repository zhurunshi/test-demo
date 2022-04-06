package pers.rush.test.threadlocal;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadLocalTest {
	static ThreadPoolExecutor exec = new ThreadPoolExecutor(20, 20, 10, TimeUnit.MINUTES,
            new LinkedBlockingQueue<>()); // 初始化线程池
	static ThreadLocal<A> local = new ThreadLocal<>(); // 初始化ThreadLocal
	static class A {
		private byte[] bytes = new byte[1024 * 1024 * 5];  // 5M
	}
	public static void main(String[] args) throws InterruptedException {
//		Thread.sleep(8000);
		for (int i = 0; i < 500; i++) {
			Thread.sleep(1000);
			exec.execute(
					() -> {
						local.set(new A());
//						local = null;
						local.remove();
					}
					); // 线程池执行线程，ThreadLocal中set对象A，创建堆内存空间
			System.out.println("提交第" + i + "个线程");
		}
	}
}
