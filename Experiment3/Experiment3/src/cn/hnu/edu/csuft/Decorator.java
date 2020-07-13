package cn.hnu.edu.csuft;

public abstract class Decorator extends ReadWord {
	protected ReadWord readWord;

	public Decorator(ReadWord readWord) {
		super();
		this.readWord = readWord;
	}

	
}
