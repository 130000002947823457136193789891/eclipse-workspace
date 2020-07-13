package ex8;

public abstract class BankTemplateMethod {
	
	public void process() {
		this.takeNumber();
		this.transact();
		if(this.isEvaluate()==true) {
		    this.evaluate();
		}else {
			//不打分
		}
	}
	public void takeNumber() {
		System.out.println("排队");
	}
	public abstract void transact();
	public void evaluate() {
		System.out.println("打10分");
	}
	public boolean isEvaluate() {
		return true;
	}

}
