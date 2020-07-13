package 可口可乐销售;
/**
 * 
 * @author 16770
 *
 */

public class Application {

	public static void main(String[] args) {
		//1.代理商选择商品进货
		System.out.println("====================1.代理商选择进货=================");
		//代理商是具有唯一性的。选择的商品种类有原型模式
		System.out.println("开始发送邮件.......");
		Dailishang dailishang=Dailishang.getInctance();//代理商
		Jieshoufang jieshoufang=new Jieshoufang("可口可乐&百事可乐公司","12345678@email");
		Youjian youjian=new Youjian("代理商",jieshoufang);
		dailishang.operation(youjian);
		Youjian copyYoujian=dailishang.copyYoujian;
		//向可口可乐选择商品
		jieshoufang.setName("可口可乐公司");
		//向百事公司选择商品
//		jieshoufang.setName("百事可乐公司");
		copyYoujian.setJieshoufang(jieshoufang);//向可乐公司发邮件
		dailishang.setYoujian(copyYoujian);
		System.out.println("代理商向可口可乐公司请求进货，可口可乐*x件，");
		System.out.println("发件人："+dailishang.getYoujian().getSender()+"，收件人："+dailishang.getYoujian().getJieshoufang()+" ");
		System.out.println("邮件发送中...   发送成功！！！");
		System.out.println("等待可口可乐公司进货");
		
		//2.公司供货
		System.out.println("===================2.可乐公司供货====================");
		//可口可乐公司生产商品
		Factory coca=new CocaFactory();
		coca.produce().produce();
		//百事公司生产
//		Factory baishi=new BaishiFactory();
//		baishi.produce().produce();
		System.out.println("已发货请注意查收！，邮件发送中...   发送成功！！");
		
		//3.顾客下单
		System.out.println("===================3.销售给顾客===============");
		//用建造者模式先下单
		BuildOrder buildOrder=new BuildOrder();
		buildOrder.setName("张三");
		buildOrder.setGoodsName("可口可乐");//或百事可乐
		buildOrder.setAddress("长沙");
		//生成可口可乐公司，唯一性
		CocaCompany cocaCompany=CocaCompany.getInstance();
		cocaCompany.construct(buildOrder);
		
		//选择快递的方式运输
//		ProxySonghuo songhuo=new SonghuoMethod(true);
//		songhuo.selectMethod();
		//选择到店自取的方式送货物
		ProxySonghuo songhuo=new SonghuoMethod(false);
		songhuo.selectMethod();
		
		System.out.println("===============================================");
		System.out.println("感谢您购买我们的商品，祝您购物愉快！");
		
	}

}
