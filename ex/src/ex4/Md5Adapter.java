package ex4;

public class Md5Adapter extends DataOperator {
	private Md5 md5;

	public Md5Adapter(Md5 md5) {
		super();
		this.md5 = md5;
	}

	@Override
	public void doEncrypt(int key, String paw) {
		this.md5.doEncrypt(key, this.getPassword());
	}

}
