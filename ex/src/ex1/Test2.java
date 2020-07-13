package ex1;

/**
 * setter
 * @author 16770
 *
 */

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OnOrOff onOrOff = new OnOrOff();
		XiaoMi xiaoMi = new XiaoMi();
		TCL tcl = new TCL();
		onOrOff.setter(xiaoMi);
		onOrOff.open();
		onOrOff.close();
		onOrOff.setter(tcl);
		onOrOff.open();
		onOrOff.close();

	}

	interface Controller {
		public void open() ;
		public void close() ;
		public void setter(TV tv);
	}
	
	static class OnOrOff implements Controller {
		private TV tv;

		@Override
		public void open() {
			// TODO Auto-generated method stub
			this.tv.on();
		}

		@Override
		public void close() {
			// TODO Auto-generated method stub
			this.tv.off();
		}

		@Override
		public void setter(TV tv) {
			// TODO Auto-generated method stub
			this.tv = tv;
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
