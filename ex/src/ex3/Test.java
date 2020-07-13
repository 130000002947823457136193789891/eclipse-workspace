package ex3;

public class Test {

	public static void main(String[] args) {
		ReadEnglishWord readEnglishWord = new ReadEnglishWord();
		KonwChineseTranslation konwChineseTranslation = new KonwChineseTranslation(readEnglishWord);
		KnowEG knowEG = new KnowEG(readEnglishWord);
		readEnglishWord.read();
		konwChineseTranslation.read();
		knowEG.read();
	};
	
	
	static abstract class ReadWord{
		public abstract void read();
	}
	
	static class ReadEnglishWord extends ReadWord{

		@Override
		public void read() {
			System.out.println("Reading english word...");
		}
		
	}
	
	static abstract class WordDecorator extends ReadWord {
		private ReadWord readword;

		public WordDecorator(ReadWord readword) {
			super();
			this.readword = readword;
		}
		
	}
	
	static class KonwChineseTranslation extends WordDecorator{

		public KonwChineseTranslation(ReadWord readword) {
			super(readword);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void read() {
			System.out.println("Knowing the Chinese Translation...");
		}
		
	}
	
	static class KnowEG extends WordDecorator{

		public KnowEG(ReadWord readword) {
			super(readword);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void read() {
			System.out.println("Knowing the eg...");
		}
		
	}
	
	
	

}
