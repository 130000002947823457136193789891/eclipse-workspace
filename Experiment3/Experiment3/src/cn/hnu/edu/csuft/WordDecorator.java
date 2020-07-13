package cn.hnu.edu.csuft;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class WordDecorator extends Decorator {
	File decoratorFile;
	
	public WordDecorator(ReadWord readWord, File decoratorFile) {
		super(readWord);
		this.decoratorFile = decoratorFile;
	}
	

	@Override
	public ArrayList<String> readWord(File file) {
		ArrayList<String> wordList = readWord.readWord(file);
		try {
			FileReader reader = new FileReader(decoratorFile);
			BufferedReader bufferedReader = new BufferedReader(reader);
			String s = null;
			int m = 0;
			while((s=bufferedReader.readLine())!=null) {
				String word = wordList.get(m);
				word = word.concat(" | " + s);
				wordList.set(m, word);
				m++;
				
				if (m > wordList.size()) { break;}
			}
			reader.close();
			bufferedReader.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return wordList;
	}

}
