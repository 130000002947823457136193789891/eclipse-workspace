import java.io.*;
public class File3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String thisLine;
		BufferedReader in=new BufferedReader(new FileReader("a.txt"));
		while ((thisLine=in.readLine())!=null)
			System.out.println(thisLine);
		in.close();
	}

}
