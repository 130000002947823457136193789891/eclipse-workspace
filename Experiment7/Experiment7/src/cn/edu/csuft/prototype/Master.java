package cn.edu.csuft.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 主机
 * @author Administrator
 *
 */
public class Master implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String cpu;
	private String memory;
	private String disk;
	
	public Master(String cpu, String memory, String disk) {
		super();
		this.cpu = cpu;
		this.memory = memory;
		this.disk = disk;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getMemory() {
		return memory;
	}

	public void setMemory(String memory) {
		this.memory = memory;
	}

	public String getDisk() {
		return disk;
	}

	public void setDisk(String disk) {
		this.disk = disk;
	}

	@Override
	public String toString() {
		return "Master [cpu=" + cpu + ", memory=" + memory + ", disk=" + disk + "]";
	}
	
	public Object deepClone() throws Exception {
		//将对象写入流中
		ByteArrayOutputStream bao=new ByteArrayOutputStream();
		ObjectOutputStream oos=new ObjectOutputStream(bao);
		oos.writeObject(this);
		
		//将对象从流中取出
		ByteArrayInputStream bis=new ByteArrayInputStream(bao.toByteArray());
		ObjectInputStream ois=new ObjectInputStream(bis);
		return(ois.readObject());
	}
	
}
