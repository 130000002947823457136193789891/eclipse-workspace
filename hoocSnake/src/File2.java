import java.io.*;

public class File2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedWriter out=new BufferedWriter(new FileWriter("a.txt"));
		out.write("广东金融学院");
		out.newLine();
		out.write("Java程序设计");
		out.flush();
		out.close();
	}

}
