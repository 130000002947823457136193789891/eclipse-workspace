package ex6.simpleFactoryM;

public class LogDB implements Log {

	
	public void saved(String cnt) {
		System.out.println("已保存在数据库中");
		System.out.println("保存内容为："+cnt);
	}

}
