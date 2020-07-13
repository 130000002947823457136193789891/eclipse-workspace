package cn.hnu.edu.csuft;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Application {

	public static void main(String[] args) throws IOException {
		// 原始功能
//		ReadEnglishWord readEnglishWord = new ReadEnglishWord();
//		ArrayList<String> WordList = readEnglishWord.readWord(new File("./src/cn/hnu/edu/csuft/english.txt"));
//		for (String word : WordList) {
//			System.out.println(word);
//		}
		
		// 采用装饰器添加功能
		ReadEnglishWord readEnglishWord = new ReadEnglishWord();
		WordDecorator decorator = new WordDecorator(readEnglishWord, new File("./src/cn/hnu/edu/csuft/chinese.txt"));	
		ArrayList<String> decoratorWordList = decorator.readWord(new File("./src/cn/hnu/edu/csuft/english.txt"));
		for (String word : decoratorWordList) {
			System.out.println(word);
		}
	}

}
