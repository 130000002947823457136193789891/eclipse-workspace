package cn.edu.csuft;

import java.math.BigInteger;

public class UseBigInteger implements Handler {
	private Handler handler;
	
	@Override
	public void computerMutiply(String number) {
		BigInteger ONE = new BigInteger("1");
		BigInteger result = new BigInteger("1");
		BigInteger n = new BigInteger(number);
		BigInteger i = new BigInteger("1");
		while(i.compareTo(n) <= 0) {
			result = result.multiply(i);
			i = i.add(ONE);
		}
		System.out.println(number + "的阶乘：" + result);
	}

	@Override
	public void setNextHandler(Handler handler) {
		this.handler = handler;
	}
}
