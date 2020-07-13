package ex6.FactoryMethodM;

public class FactoryLogFile implements Factory {
	public Log produceLog() {
		return new LogFile();
	}
}
