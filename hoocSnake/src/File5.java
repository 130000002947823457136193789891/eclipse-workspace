import java.io.*;
public class File5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] dir=new java.io.File(".").list();
		java.util.Arrays.sort(dir);
		for(int i=0;i<dir.length;i++) 
			System.out.println(dir[i]);
		//�鿴ϵͳ�������б�
		File[] drives=File.listRoots();
		for(int i=0;i<drives.length;i++)
			System.out.println(drives[i]);
	}

}
