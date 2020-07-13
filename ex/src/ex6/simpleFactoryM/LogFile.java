package ex6.simpleFactoryM;

public class LogFile implements Log {

	
	public void saved(String cnt) {
		System.out.println("已保存在文件中");
		System.out.println("保存内容为："+ cnt);
	}

	

}
