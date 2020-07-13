package cn.edu.csuft;

public class UseInt implements Handler{
	private Handler handler;

	@Override
	public void computerMutiply(String number) {
		int result = 1;
		int n = Integer.parseInt(number);
		int i = 1;
		while(i < n) {
			result = result*i;
			if (result <= 0) {
				System.out.println("超出int的计算范围，计算不了");
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
