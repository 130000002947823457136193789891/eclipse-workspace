import java.io.*;
class Student implements Serializable
{
	String name;
	int age;
	String dept;
	public Student(String newName,int newAge,String newDept)
	{
		name=newName;
		age=newAge;
		dept=newDept;
	}
	public String toString()
	{
		return name+" "+age+" "+dept;
	}
}
public class ReadWriteObject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student w1=new Student("张三", 20, "计算机系");
		Student w2=new Student( "李四", 21,  "金融系");
		FileOutputStream fout;;
		ObjectOutputStream dout;
		FileInputStream fin;
		ObjectInputStream din;
		File f=new File( "ReadWriteObject.txt");
		try
		{
			f.createNewFile();
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		try
		{
			fout=new FileOutputStream(f);
			dout=new ObjectOutputStream(fout);
			dout.writeObject(w1);
			dout.writeObject(w2);
			dout.close();
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		try
		{
			fin=new FileInputStream(f);
			din=new ObjectInputStream(fin);
			Student r1=(Student)din.readObject();
			Student r2 =(Student)din.readObject();
			System.out.println(r1.toString());
			System.out.println(r2.toString());
			din.close();
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		catch(Exception e)
		{
		System.out.println(e);
		}
	}

}
