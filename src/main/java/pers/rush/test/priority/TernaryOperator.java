package pers.rush.test.priority;

class BaseEntity {
	String s1;
	String s2;
	public String getS1() {
		return s1;
	}
	public void setS1(String s1) {
		this.s1 = s1;
	}
	public String getS2() {
		return s2;
	}
	public void setS2(String s2) {
		this.s2 = s2;
	}
}

class BaseVO {
	String s1;
	String s2;
	public String getS1() {
		return s1;
	}
	public void setS1(String s1) {
		this.s1 = s1;
	}
	public String getS2() {
		return s2;
	}
	public void setS2(String s2) {
		this.s2 = s2;
	}
}

public class TernaryOperator {
	public static boolean isEmpty(String s) {
		return true;
	}
	
	public static void main(String[] args) {
		BaseEntity entity = new BaseEntity();
		BaseVO vo = new BaseVO();
		vo.setS1(isEmpty(entity.getS1()) ? "": entity.getS1());
		vo.setS2(isEmpty(entity.getS2()) ? "" : entity.getS2());
		System.out.println(vo.getS1());
		System.out.println(vo.getS2());
	}
}
