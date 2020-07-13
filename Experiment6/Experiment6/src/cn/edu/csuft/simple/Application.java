package cn.edu.csuft.simple;

public class Application {

	public static void main(String[] args) {
		LogFactory factory = new LogFactory();
//		Log log = factory.createLog("file");
//		log.writeLog("张三修改了系统管理员的权限");
		
		Log log = factory.createLog("database");
		log.writeLog("张三删除了用户李四");
	}

}
