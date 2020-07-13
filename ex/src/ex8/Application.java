package ex8;

public class Application {

	public static void main(String[] args) {
		Deposit d = new Deposit();
		Tansfer t = new Tansfer();
		Withdraw w= new Withdraw();
		d.process();
		System.out.println();
		t.process();
		System.out.println();
		w.process();
	}

}
