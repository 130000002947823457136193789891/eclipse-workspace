package 可口可乐销售;

public class BaishiFactory extends Factory {
	public Order builder;

	@Override
	public Goods produce() {
		return new Baishi();
	}


}
