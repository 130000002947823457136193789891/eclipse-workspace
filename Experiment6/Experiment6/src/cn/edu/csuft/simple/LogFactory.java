package cn.edu.csuft.simple;

public class LogFactory {
	public static Log createLog(String name) {
		if (name.equalsIgnoreCase("file")) {
			return new FileLog();
		} else if (name.equalsIgnoreCase("database")) {
			return new DatabaseLog();
		}
		return null;
	}
}
