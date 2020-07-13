package ex6.FactoryMethodM;

public class FactoryLogDB implements Factory {
	public Log produceLog() {
		return new LogDB();
	}
}
