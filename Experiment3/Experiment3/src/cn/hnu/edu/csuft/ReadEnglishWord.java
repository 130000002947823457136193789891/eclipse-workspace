package cn.hnu.edu.csuft;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class ReadEnglishWord extends ReadWord {

	@Override
	public ArrayList<String> readWord(File file) {
		ArrayList<String> wordList = new ArrayList<String>();
		try {
			FileReader reader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(reader);
			String s = null;
			while((s=bufferedReader.readLine())!=null) {
				wordList.add(s);
			}
			reader.close();
			bufferedReader.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return wordList;
	}

}
