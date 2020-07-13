package ex4;

public class CaesarAdapter extends DataOperator {
	private Caesar caesar;

	public CaesarAdapter(Caesar caesar) {
		super();
		this.caesar = caesar;
	}

	@Override
	public void doEncrypt(int key, String paw) {
		this.caesar.doEncrypt(key, this.getPassword());
	}

}
