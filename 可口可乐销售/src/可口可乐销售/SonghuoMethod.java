package 可口可乐销售;

public class SonghuoMethod extends ProxySonghuo {
	boolean flag;
	public SonghuoMethod(boolean flag) {
		this.flag=flag;
	}
	

	@Override
	public Songhuo selectMethod() {
		if(flag) { //快递
			System.out.println("选择快递公司进行代理。");
			return new Kuaidi();
		}else {
			System.out.println("选择到店自取的方式。");
			return new Ziqu();
		}
	}

	@Override
	public void songhuo() {
		
	}

}
