package ex5;

public class UseLong implements Handler {
	Handler handler = new UseBigInteger();
	private String number;
	

	@Override
	public void computeMultiply(String number) {
		this.number = number;
		long n = Integer.valueOf(number);
		long result=1;
		long i;
		for (i = 1; i <= n; i++) {
			result *= i;
			if(result<0) {
				this.setNextHandler(handler);
				break;
			}
		}
		if(i>n) {
			System.out.println("结果为long型，即"+result+".");
		}
	}

	@Override
	public void setNextHandler(Handler handler) {

		System.out.println("用Long型处理不了结果，结果超出了范围。");
		handler.computeMultiply(number);
	}

}
