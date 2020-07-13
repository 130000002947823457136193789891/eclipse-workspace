package ex1;

/**
 * construction
 * @author 16770
 *
 */

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Controller c = new Controller ();
		c.openTV(new TCL());
		c.closeTV(new TCL());
	}
	
	static class Controller {
		public void openTV(TV tv) {
			tv.on();
		}
		
		public void closeTV(TV tv) {
			tv.off();
		}
		
	}
	
	interface TV {
		public void on() ;
		public void off();
	}
	
	static class XiaoMi implements TV {

		@Override
		public void on() {
			// TODO Auto-generated method stub
			System.out.println("XioaMi is opening...");
		}

		@Override
		public void off() {
			// TODO Auto-generated method stub
			System.out.println("XiaoMi has been closed.");
		}
		
	}
	
	static class TCL implements TV {

		@Override
		public void on() {
			// TODO Auto-generated method stub
			System.out.println("TCL is opening...");
		}

		@Override
		public void off() {
			// TODO Auto-generated method stub
			System.out.println("TCL has been closed.");
		}
		
	}

}
