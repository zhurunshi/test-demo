package pers.rush.test.mutex;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class WriteReadLockDemo {
	String name = "Alice";
	String sex = "女";

	private static final java.util.concurrent.locks.ReadWriteLock LOCK = new ReentrantReadWriteLock(); // 读写锁

	public void setValue(String name, String sex) {
		// 1.获取写锁
		Lock writeLock = LOCK.writeLock();
		// 2.上写锁
		writeLock.lock();
		
		// 3.主逻辑
		this.name = name;
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.sex = sex;
		System.out.println("setValue[name: " + this.name + ", sex: " + this.sex + "]");

		// 4.释放写锁
		writeLock.unlock();
	}

	public void getValue() {
		// 1.获取读锁
		Lock readLock = LOCK.readLock();
		// 2.上读锁
		readLock.lock();

		// 3.主逻辑
		try {
			System.out.println(Thread.currentThread().getName() + "：我得好好读读，没进来的多等会吧......");
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "：getValue[name: " + name + ", sex: " + sex + "]");

		// 4.释放读锁
		readLock.unlock();
	}

	public static void main(String[] args) throws InterruptedException {
		WriteReadLockDemo wrlock = new WriteReadLockDemo();
		Thread t1 = new Thread(() -> wrlock.setValue("tom", "男"));
		t1.start();
		Thread.sleep(1000);

		Thread t2 = new Thread(() -> wrlock.getValue());
		Thread t3 = new Thread(() -> wrlock.getValue());
		Thread t4 = new Thread(() -> wrlock.getValue());
		Thread t5 = new Thread(() -> wrlock.getValue());
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}
}
