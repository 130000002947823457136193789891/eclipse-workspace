import java.io.*;
public class WriteFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileWriter fw=new FileWriter("test.txt");
		String str1="广东金融学院";
		String str2="欢迎使用Java！";
		fw.write(str1);
		fw.write(str2);
		fw.close();
		System.out.println("内容以写入到文件test.txt中");
	}

}
