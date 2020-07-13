package ex6.simpleFactoryM;

public class Factory {
	private Log log;
	
	public Log produceLog(String t) {
		if(t.equalsIgnoreCase("DB")) {
			return new LogDB();
		} else if(t.equalsIgnoreCase("File")) {
			return new LogFile();
			
		} else {
			return null;
		}
	}
}
