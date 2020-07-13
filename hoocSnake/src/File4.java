import java.io.*;
import java.util.*;
public class File4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		if(args.length==0)
		{
			System.out.println("ȱ���ļ���");
			System.exit(1);
		}
		for(int i=0;i<args.length;i++)
		{
			status(args[i]);
		}
	}
	public static void status(String fileName) throws IOException
	{
		System.out.println("---"+fileName+"---");
		File f=new File(fileName);
		if(!f.exists())
		{
			System.out.println("�ļ�û���ҵ�");
			System.out.println();
			return;
		}
		System.out.println("�ļ�ȫ��Ϊ"+f.getCanonicalPath());
		String p=f.getParent();
		if(p!=null)
			System.out.println("Parent directory:"+p);
		if(f.canRead())
			System.out.println("File is readable.");
		if(f.canWrite())
			System.out.println("File is writeable.");
		Date d=new Date();
		d.setTime(f.lastModified());
		System.out.println("Last modified"+d);
		if(f.isFile())
			System.out.println("�ļ���С��"+f.length()+" bytes.");
		else if(f.isDirectory())
			System.out.println("����Ŀ¼");
		else
			System.out.println("�Ȳ����ļ�Ҳ����Ŀ¼");
		System.out.println();
	}

}
