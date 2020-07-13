package cn.edu.csuft.singleton;

/**
 * 懒汉式
 * @author Administrator
 *
 */
public class Singleton6 {
	private static Singleton6 instance;
	
	private Singleton6() {}
	
	public static Singleton6 getInstance() {	
		if (null == instance) {
			try {				
				synchronized (Singleton6.class) {
					if (null == instance) {
						Thread.sleep(300);
						instance = new Singleton6();
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return instance;
	}
}
