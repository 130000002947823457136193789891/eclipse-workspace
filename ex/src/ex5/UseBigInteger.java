package ex5;

import java.math.BigInteger;

public class UseBigInteger implements Handler {

	@Override
	public void computeMultiply(String number) {
		BigInteger n= new BigInteger(number);
		BigInteger result = n;
		BigInteger i= new BigInteger("1");
		BigInteger ONE = new BigInteger("1");
		while( i.compareTo(n)==-1) {
			
			result=result.multiply(i);
			i=i.add(ONE);
		}
		System.out.println("结果为BigInteger型，即"+result+".");
	}

	@Override
	public void setNextHandler(Handler handler) {
		
	}

}
