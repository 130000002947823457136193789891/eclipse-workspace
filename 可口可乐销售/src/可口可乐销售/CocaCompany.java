package 可口可乐销售;

public class CocaCompany {

	public Songhuo songhuo;
	public ProxySonghuo proxyKuaidi;
	
	//单例模式
	private CocaCompany(){};
	private static class SingletonInstance{
		private static final CocaCompany INSTANCE= new CocaCompany();
	}
	
	public static CocaCompany getInstance() {
		return SingletonInstance.INSTANCE;
	}
	
	public void construct(Order order) {
		
		order.getResult();
	}

}
