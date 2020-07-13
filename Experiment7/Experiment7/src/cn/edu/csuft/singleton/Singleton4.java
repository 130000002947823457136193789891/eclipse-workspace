package cn.edu.csuft.singleton;

/**
 * 懒汉式
 * @author Administrator
 *
 */
public class Singleton4 {
	private static Singleton4 instance;
	
	private Singleton4() {}
	
	public synchronized static Singleton4 getInstance() {
		if (null == instance) {
			try {
				Thread.sleep(300);
				instance = new Singleton4();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return instance;
	}
}
