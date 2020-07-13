package cn.edu.csuft.function;

public class Application {

	public static void main(String[] args) {
//		LogFactory factory = new FileLogFactory();
//		Log log = factory.createLog();
//		log.writeLog("张三修改了李四的姓名，出现了异常");
		
		LogFactory factory = new DatabaseLogFactory();
		Log log = factory.createLog();
		log.writeLog("张三修改了李四的姓名，出现了异常");
	}

}
