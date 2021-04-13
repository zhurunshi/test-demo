package pers.rush.test.mutex;

/**
 * 脏读演示
 * @author Rush
 *
 */
public class DirtyReadDemo {
	String name = "Alice";
	String sex = "女";
	
	public void setValue(String name, String sex) {
		this.name = name;
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.sex = sex;
		System.out.println("setValue[name: " + this.name + ", sex: " + this.sex + "]");
	}
	
	public void getValue() {
		System.out.println("getValue[name: " + name + ", sex: " + sex + "]");
	}
	
	public static void main(String[] args) throws InterruptedException {
		DirtyReadDemo dr = new DirtyReadDemo();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				dr.setValue("tom", "男");
			}
		});
		t1.start();
		Thread.sleep(1000);
		dr.getValue();
	}
}
