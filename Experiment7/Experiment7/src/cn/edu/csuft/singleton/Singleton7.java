package cn.edu.csuft.singleton;

/**
 * 静态内部类
 * @author Administrator
 *
 */
public class Singleton7 {
	
	private Singleton7() {}
	
	private static class SingletonClass {
		private static Singleton7 instance = new Singleton7();
	}
	
	public static Singleton7 getInstance() {
		return SingletonClass.instance;
	}

}
