import java.io.*;
public class File6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File target=new File( "a.txt");
		if(!target.exists())
			System.out.println("�ļ�������");
		else if(target.delete())
			System.out.println("�ļ���ɾ��");
		else
			System.out.println("�ļ�����ɾ��");
	}

}
