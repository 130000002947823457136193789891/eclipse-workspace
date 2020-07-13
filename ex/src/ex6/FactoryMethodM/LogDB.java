package ex6.FactoryMethodM;

public class LogDB implements Log {
	public void saved(String cnt) {
		System.out.println("保存在数据库中。");
		System.out.println("保存内容为："+cnt);
	}
}
