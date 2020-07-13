package cn.edu.csuft.simple;

public class FileLog implements Log{

	@Override
	public void writeLog(String cnt) {
		System.out.println("使用文件记录日志");
		System.out.println("日志内容为：" + cnt);
	}

}
