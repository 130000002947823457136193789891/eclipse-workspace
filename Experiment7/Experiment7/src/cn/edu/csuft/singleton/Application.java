package cn.edu.csuft.singleton;

public class Application extends Thread {
	
	public void run() {
		System.out.println(Singleton8.INSTANCE.hashCode());
	}

	public static void main(String[] args) {
		// 饿汉式1
//		Singleton1 singleton1 = Singleton1.getInstance();
//		Singleton1 singleton2 = Singleton1.getInstance();
//		System.out.println("singleton1:" + singleton1.hashCode());
//		System.out.println("singleton2:" + singleton2.hashCode());
		
		// 饿汉式2
//		Singleton2 singleton1 = Singleton2.getInstance();
//		Singleton2 singleton2 = Singleton2.getInstance();
//		System.out.println("singleton1:" + singleton1.hashCode());
//		System.out.println("singleton2:" + singleton2.hashCode());
		
		// 懒汉式1
//		Singleton3 singleton1 = Singleton3.getInstance();
//		Singleton3 singleton2 = Singleton3.getInstance();
//		System.out.println("singleton1:" + singleton1.hashCode());
//		System.out.println("singleton2:" + singleton2.hashCode());
		
		Application[] apps = new Application[10];
		for (int i=0; i< 10; i++) {
			apps[i] = new Application();
		}
		
		for (int j=0; j<10; j++) {
			apps[j].start();
		}
	}

}
