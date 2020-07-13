package ex6.simpleFactoryM;

public class Application {

	public static void main(String[] args) {
//		Factory factory = new Factory();
//		String t="File";
//		Log log = factory.produceLog(t);
//		log.saved("nihao");
		
		Factory factory = new Factory();
		String t="DB";
		Log log = factory.produceLog(t);
		log.saved("nihao");
	}

}
