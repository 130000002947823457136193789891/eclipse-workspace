package ex4;

public class Application {

	public static void main(String[] args) {
		//初始化
		Caesar caesar = new Caesar();
		Md5 md5 = new Md5();
		Md5Adapter md5Adapter = new Md5Adapter(md5);
		CaesarAdapter caesarAdapter = new CaesarAdapter(caesar);
		
		//调用不同的适配器对数据加密
		//设置密码
		caesarAdapter.setPassword("1234567890"); //我将凯撒加密只用于字符串是数字的情况
		md5Adapter.setPassword("abcdeefg");  //我将Md5加密只用于字符串是英文字母的情况
		caesarAdapter.doEncrypt(3, caesarAdapter.getPassword()); //设置密钥是3，将输出用凯撒对字符串进行加密
		md5Adapter.doEncrypt(3, md5Adapter.getPassword());  //同样设置密钥是3，将输出用md5加密字符串
	}

}
