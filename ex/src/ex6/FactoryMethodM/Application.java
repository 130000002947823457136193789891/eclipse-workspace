package ex6.FactoryMethodM;

public class Application {

	public static void main(String[] args) {
//		Factory factory = new FactoryLogDB();
//		Log log = factory.produceLog();
//		log.saved("hello,logDB.");
		
		Factory factory = new FactoryLogFile();
		Log log = factory.produceLog();
		log.saved("hello,logFile.");
	}

}
