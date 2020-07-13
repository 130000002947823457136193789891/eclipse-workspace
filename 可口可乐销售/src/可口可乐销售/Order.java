package 可口可乐销售;

public abstract class Order {
	
	public abstract void setName(String name);
	public abstract void setAddress(String address);
	public abstract void setGoodsName(String goodsName);
	
	public abstract String getName();
	public abstract String getAddress();
	public abstract String getGoodsName(); //可口可乐或百事可乐
	public abstract void getResult();

}
