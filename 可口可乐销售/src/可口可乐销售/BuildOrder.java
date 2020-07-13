package 可口可乐销售;

public class BuildOrder extends Order {
	public String name;
	public String address;
	public String goodsName;
	@Override
	public void setName(String name) {
		this.name=name;
	}
	@Override
	public void setAddress(String address) {
		this.address=address;
	}
	@Override
	public void setGoodsName(String goodsName) {
		this.goodsName=goodsName;
	}
	
	@Override
	public void getResult() {
		System.out.println("订单生成中...");
		System.out.println("顾客姓名："+this.name);
		System.out.println("购买商品："+this.goodsName);
		System.out.println("顾客地址："+this.address);

	}
	@Override
	public String getName() {
		return name;
	}
	@Override
	public String getAddress() {
		return address;
	}
	@Override
	public String getGoodsName() {
		return goodsName;
	}


}
