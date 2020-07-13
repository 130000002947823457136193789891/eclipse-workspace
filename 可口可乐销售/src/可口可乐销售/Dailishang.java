package 可口可乐销售;

public class Dailishang {
	
	//===============================单例模式
	private Dailishang(){};
	private static class SingletonInstance{
		private static final Dailishang INSTANCE=new Dailishang();
	}
	
	public static Dailishang getInctance() {
		return SingletonInstance.INSTANCE;
	}
	
	//===================================
	//邮件原型模式
	
	public Youjian youjian;
	public Youjian copyYoujian;
	
	public void operation(Youjian youjian) {
		this.youjian=youjian;
		copyYoujian=(Youjian) youjian.clone();
	}
	
	public void setYoujian(Youjian youjian) {
		this.youjian=youjian;
	}
	
	public Youjian getYoujian() {
		return this.copyYoujian;
	}
	
	//======================================
	

}
