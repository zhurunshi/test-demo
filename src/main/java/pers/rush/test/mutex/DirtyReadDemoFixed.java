package pers.rush.test.mutex;

/**
 * 可重入读写锁演示
 * @author Rush
 *
 */
public class DirtyReadDemoFixed {
	String name = "Alice";
	String sex = "女";
	
	public synchronized void setValue(String name, String sex) {
		this.name = name;
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.sex = sex;
		System.out.println("setValue[name: " + this.name + ", sex: " + this.sex + "]");
	}
	
	public synchronized void getValue() {
		try {
			System.out.println(Thread.currentThread().getName() + "：我得好好读读，没进来的多等会吧......");
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("getValue[name: " + name + ", sex: " + sex + "]");
	}
	
	public static void main(String[] args) throws InterruptedException {
		DirtyReadDemoFixed drf = new DirtyReadDemoFixed();
		Thread t1 = new Thread(() -> drf.setValue("tom", "男"));
		t1.start();
		Thread.sleep(1000);
		
		Thread t2 = new Thread(() -> drf.getValue());
		Thread t3 = new Thread(() -> drf.getValue());
		Thread t4 = new Thread(() -> drf.getValue());
		Thread t5 = new Thread(() -> drf.getValue());
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}
}
