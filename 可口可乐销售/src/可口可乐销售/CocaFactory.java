package 可口可乐销售;

public class CocaFactory extends Factory {
	public Order builder;

	@Override
	public Goods produce() {
		return new Coca();
	}

	

}
