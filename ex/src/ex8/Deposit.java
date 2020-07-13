package ex8;

public class Deposit extends BankTemplateMethod {


	@Override
	public void transact() {
		System.out.println("存钱");
	}
	
	@Override
	public boolean isEvaluate() {
		return false;
	}

}
