package ex6.FactoryMethodM;

public class LogFile implements Log {
	public void saved(String cnt) {
		System.out.println("保存在文件中。");
		System.out.println("保存内容为："+cnt);
	}
}
