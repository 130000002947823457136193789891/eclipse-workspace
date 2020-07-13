package ex5;

public class UseInt implements Handler {
	Handler handler = new UseLong();
	private String number;

	@Override
	public void computeMultiply(String number) {
		this.number = number;
		int n = Integer.valueOf(number);
		int result=1;
		int i;
		for (i = 1; i <= n; i++) {
			result *= i;
			if(result<0) {
				this.setNextHandler(handler);
				break;
			}
		}
		if(i>n) {
			System.out.println("结果为int型，即"+result+".");
		}
	}

	@Override
	public void setNextHandler(Handler handler) {
		System.out.println("用int型处理不了结果，结果超出了范围。");
		handler.computeMultiply(number);
	}

}
