package cn.edu.csuft.singleton;

/**
 * 懒汉式
 * @author Administrator
 *
 */
public class Singleton3 {
	private static Singleton3 instance;
		
	private Singleton3() {}
	
	public static Singleton3 getInstance() {
		if (null == instance) {
			try {
				Thread.sleep(300);
				instance = new Singleton3();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return instance;
	}
}
