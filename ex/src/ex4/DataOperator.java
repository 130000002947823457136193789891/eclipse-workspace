package ex4;

public abstract class DataOperator {
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public abstract void doEncrypt(int key, String paw) ;
}
