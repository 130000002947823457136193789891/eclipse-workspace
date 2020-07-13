package ex7;

/**
 * 饿汉式，事先加载好
 * @author 16770
 *
 */
public class Singleton1 {
	private static Singleton1 instance= new Singleton1();
	
	private Singleton1() {}
	
	private static Singleton1 getInstance() {
		return instance;
	}
}
