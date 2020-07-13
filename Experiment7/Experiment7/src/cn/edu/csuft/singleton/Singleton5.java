package cn.edu.csuft.singleton;

/**
 * 懒汉式
 * @author Administrator
 *
 */
public class Singleton5 {
	private static Singleton5 instance;
	
	private Singleton5() {}
	
	public static Singleton5 getInstance() {
		synchronized (Singleton5.class) {
			if (null == instance) {
				try {
					Thread.sleep(300);
					instance = new Singleton5();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		return instance;
	}
}
