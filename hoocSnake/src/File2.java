import java.io.*;

public class File2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedWriter out=new BufferedWriter(new FileWriter("a.txt"));
		out.write("�㶫����ѧԺ");
		out.newLine();
		out.write("Java�������");
		out.flush();
		out.close();
	}

}
