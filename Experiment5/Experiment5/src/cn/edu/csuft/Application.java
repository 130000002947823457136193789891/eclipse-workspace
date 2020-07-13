package cn.edu.csuft;

public class Application {

	public static void main(String[] args) {
		UseInt useInt = new UseInt();
		UserLong userLong = new UserLong();
		UseBigInteger useBigInteger = new UseBigInteger();
		
		useInt.setNextHandler(userLong);
		userLong.setNextHandler(useBigInteger);
		
		
		useInt.computerMutiply("32");
	}

}
