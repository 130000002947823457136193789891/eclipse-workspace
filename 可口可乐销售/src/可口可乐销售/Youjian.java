package 可口可乐销售;

public class Youjian implements Cloneable {
	//邮件发送方是代理商，接收方是可口可乐公司或是百事公司
	public String sender;
	public Jieshoufang jieshoufang;
	public Youjian(String sender,Jieshoufang jieshoufang) {
		this.sender=sender;
		this.jieshoufang=jieshoufang;
	}

	public Object clone() {
		Youjian clone=null;
		try {
			clone=(Youjian) super.clone();
		}catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return clone;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public Jieshoufang getJieshoufang() {
		return jieshoufang;
	}

	public void setJieshoufang(Jieshoufang jieshoufang) {
		this.jieshoufang = jieshoufang;
	}
	
	

}
