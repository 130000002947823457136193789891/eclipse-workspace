package cn.edu.csuft.singleton;

/**
 * 饿汉式
 * @author Administrator
 *
 */
public class Singleton2 {
	private static Singleton2 instance;
	
	static {
		instance = new Singleton2();
	}
	
	private Singleton2() {}
	
	public static Singleton2 getInstance() {
		return instance;
	}
}
