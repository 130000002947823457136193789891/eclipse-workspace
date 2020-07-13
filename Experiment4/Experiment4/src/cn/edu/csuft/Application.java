package cn.edu.csuft;

public class Application {

	public static void main(String[] args) {
//		DataOperation dao= new CipherAdapter();
//		dao.setPassword("sunny");
//		String ps = dao.getPassword();
//		String es = dao.doEncrypt(6, ps);
//		System.out.println("明文为：" + ps);
//		System.out.println("密文为：" + es);
		
		DataOperation dao= new NewCipherAdapter();
		dao.setPassword("sunny");
		String ps = dao.getPassword();
		String es = dao.doEncrypt(6, ps);
		System.out.println("明文为：" + ps);
		System.out.println("密文为：" + es);
	}

}
