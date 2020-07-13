package ex7;

public class Application extends Thread {
	public void run() {
		System.out.println(S);
	}

	public static void main(String[] args) {
		Singleton1 singleton1 = Singleton1.getInstance();
	}

}
