package cn.edu.csuft.prototype;

public class Application {

	public static void main(String[] args) throws Exception {
		Master master = new Master("i5", "8G", "1T SSD");
		Computer computer1 = new Computer(master, "三星显示器", "机械键盘");
		
		Computer computer2 = (Computer)computer1.deepClone();
		System.out.println("computer1:" + computer1.toString());
		System.out.println("computer1 hashcode:" + computer1.hashCode());
		System.out.println("computer1 master hashcode:" + computer1.getMaster().hashCode());
		System.out.println("computer2:" + computer2.toString());
		System.out.println("computer2 hashcode:" + computer2.hashCode());
		System.out.println("computer2 master hashcode:" + computer2.getMaster().hashCode());
		
		System.out.println("--------------------------------");
		computer1.getMaster().setCpu("i7");
		System.out.println("computer1:" + computer1.toString());
		System.out.println("computer2:" + computer2.toString());
		
	}

}
