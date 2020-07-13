package 可口可乐销售;

public class BaishiCompany {
	public Songhuo songhuo;
	public ProxySonghuo proxyKuaidi;
	
	//单例模式
	private BaishiCompany(){};
	private static class SingletonInstance{
		private static final BaishiCompany INSTANCE= new BaishiCompany();
	}
	
	public static BaishiCompany getInstance() {
		return SingletonInstance.INSTANCE;
	}
	
	public void construct(Order order) {
		order.getResult();
	}
}
