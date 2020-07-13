package cn.edu.csuft.function;

public class DatabaseLog implements Log {

	@Override
	public void writeLog(String cnt) {
		System.out.println("使用数据库记录日志");
		System.out.println("日志内容为：" + cnt);
	}

}
