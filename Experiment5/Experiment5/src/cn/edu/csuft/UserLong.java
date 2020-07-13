package cn.edu.csuft;

public class UserLong implements Handler{

	private Handler handler;

	@Override
	public void computerMutiply(String number) {
		long result = 1;
		long n = Long.parseLong(number);
		long i = 1;
		while(i < n) {
			result = result*i;
			if (result <= 0) {
				System.out.println("超出long的计算范围，计算不了");
				this.handler.computerMutiply(number);
				return;
			}
			i++;
		}
		System.out.println(number + "的阶乘：" + result);
	}

	@Override
	public void setNextHandler(Handler handler) {
		this.handler = handler;
	}

}
