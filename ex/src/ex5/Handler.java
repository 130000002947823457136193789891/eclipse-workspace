package ex5;

public interface Handler {
	public void computeMultiply(String number);
	public void setNextHandler(Handler handler);
}
