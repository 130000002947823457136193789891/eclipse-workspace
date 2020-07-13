package ex1;

/**
 * implements
 * @author 16770
 *
 */

public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OpenOrClose openOrClose = new OpenOrClose();
		XiaoMi xiaomi = new XiaoMi();
		TCL tcl = new TCL();
		
		openOrClose.open(xiaomi);
		openOrClose.close(xiaomi);
		
		openOrClose.open(tcl);
		openOrClose.close(tcl);
	}
	
	interface Controller {
		public void open(TV tv);
		public void close(TV tv);
	}
	
	static class OpenOrClose implements Controller {

		@Override
		public void open(TV tv) {
			// TODO Auto-generated method stub
			tv.on();
		}

		@Override
		public void close(TV tv) {
			// TODO Auto-generated method stub
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
